import java.util.*;
public class Deck {
	Stack<Card>deck;
	
	public Deck() {
		deck = new Stack<Card>();
		loadDeck();
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	// Load the stack with 52 cards in order
	public void loadDeck() {
		for(int i = 1; i<=4; i++) {
			for(int j = 2; j <=14; j++) {
				deck.push(new Card(i,j));
			}
		}
	}

	// Print the stack - for uniformity,
	// make 13 rows in four columns, filling
	// in each row from left to right
	public String toString() {
		Iterator<Card> iter = deck.iterator();		
		String s = "";
		for(int i = 0; i <= 12; i++) {
			for(int j = 0; j <= 3; j++) {
				s += iter.next().toString() + " ";
			}
			s += "\n";
		}
		return s;
	}

	// Return and remove the top card
	public Card deal() {
		return deck.pop();
	}

	// Take the top half of the deck (26 cards) and alternate card by card with
	// the bottom half
	public void bridgeShuffle() {
		Stack<Card> temp1 = new Stack<Card>();
		Stack<Card> temp2 = new Stack<Card>();
		for(int i = 0; i<=25; i++) {
			temp1.push(deck.pop());
		}
		for(int i = 0; i<=25; i++) {
			temp2.push(deck.pop());
		}
		for(int i = 0; i<=25; i++) {
			deck.push(temp2.pop());
			deck.push(temp1.pop());
		}
	}

	// Split the deck at a random spot. Put the stack of cards above the random
	// spot below the other cards
	public void cut() {
		Stack<Card> temp = new Stack<Card>();
		Stack<Card> temp2 = new Stack<Card>();
		int ran = (int)(Math.random() * 53);
		for(int i = 0; i<ran; i++) {
			temp.push(deck.pop());
		}
		for (int i = 0; i<52-ran; i++) {
			temp2.push(deck.pop());
		}
		for (int i = 0; i < 52; i++) {
			if (i < ran) 
				deck.push(temp.pop());
			else
				deck.push(temp2.pop());
		}
	}

	// Complete a bridge shuffle and then cut the deck. Repeat 7 times
	public void completeShuffle() {
		for (int i = 0; i<7; i++) {
			bridgeShuffle();
			cut();
		}
	}

	// Reverse the order of the cards in the deck
	private void reverse() {
		Stack<Card> temp = new Stack<Card>();
		for (int i = 0; i<52; i++) {
			temp.push(deck.pop());
		}
		deck = temp;
	}

	// Given a Stack of cards as an explicit parameter,
	// reverse the order of the cards in the deck
	//private Stack<Card> reverse(Stack<Card> x) {}

	// Combine two decks, one as the implicit
	// parameter, the other as the explicit parameter
	public void combineDecks(Stack<Card> other) {}

	public static void main(String[] args) {
		Deck a = new Deck();
		System.out.println("Display after DECK CONSTRUCTION \n" + a + "\n\n");
		a.cut();
		System.out.println("Display after CUT \n" + a + "\n\n");
		Deck b = new Deck();
		b.bridgeShuffle();
		System.out.println("Display after BRIDGE SHUFFLE \n" + b + "\n\n");
		Deck c = new Deck();
		c.completeShuffle();
		System.out.println("Display after COMPLETE SHUFFLE \n" + c + "\n\n");
	}
}