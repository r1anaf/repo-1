import java.util.*;

public class Blackjack {

	private Deck deck;
	private Stack<Card> p1;
	private Stack<Card> dealer;
	
	public Blackjack() {
		deck = new Deck();
		p1 = new Stack<>();
		dealer = new Stack<>();
		deck.completeShuffle();
		
	}
	
	public int total(Stack<Card> p) { 		// adds the cards in a stack to find total of player/dealer
		int total = 0;
		for (Card x : p) {
			if (x.value() == 14) {
				if (total + 11 >= 21)
					total += 1;
				else total += 11;
			}
			else if (x.value() > 10)
				total += 10;
			else
				total += x.value();
		}
		return total;
	}
	
	public String printCards(Stack<Card> p) { // prints cards currently in dealer/players hand
		String print = "";
		int i = 1;
		for (Card x : p) {
			print += "Card " + i + ": " + x.toString() + "\n";
			i++;
		}
		return print;
	}
	
	public void play() {
		System.out.println("Welcome to Blackjack!!!!!!!");
		Scanner key = new Scanner(System.in);
		int val = 1;
		System.out.println("\nPlayer 1's Turn - ");
		while (val == 1 && total(p1) < 21) { // stay in while loop as long as player didn't break yet and they want to keep playin
			p1.push(deck.deal());
			System.out.println("\n" + printCards(p1)
					+ "Your total is " + total(p1));
			if (total(p1) >= 21) { 			// checks if player breaks
				System.out.println("Player 1 Breaks, Dealer Wins");
				return;
			}
			System.out.println("\n1 for hit or -1 for stand");
			val = key.nextInt();
		}
		val = 1;
		System.out.println("\nDealer's Turn - "); 
		while (total(dealer) <= 16) { 		// dealer has to hit until 16, after which they stand
			dealer.push(deck.deal());
			System.out.println("\n" + printCards(dealer)
					+ "Dealer's total is " + total(dealer));
			if(total(dealer) >= 21) { 		// checks if dealer breaks
				System.out.println("Dealer Breaks, Player 1 Wins");
				return;
			}
		}
		if(total(p1) > total(dealer)) { 	// checks who is the winner
			System.out.println("Player 1 Wins");
		} else if((total(p1) == total(dealer))) {
			System.out.println("Tie");
		} else {
			System.out.println("Dealer Wins");
		}
	}
		
	public static void main(String[] args) {
		Blackjack one = new Blackjack();
		one.play();

	}

}
