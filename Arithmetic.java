import java.util.Stack;

public class Arithmetic {

	private String input;
	private Stack<Double> nums;
	private Stack<String> opps;
	
	public Arithmetic(String in) {
		input = in;
		nums = new Stack<>();
		opps = new Stack<>();
	}
	
	public void processInput() {
		String copy = input;
		String o = "*/+-()^";
		while(copy != "") {
			//Traverse Through String
			if (o.contains(copy.substring(0,1))) {
				opps.push(copy.substring(0,1));
				copy = copy.substring(1);
			}
			else {
				nums.push(Double.parseDouble(copy.substring(0,1)));
				copy = copy.substring(1);
			}
			//System.out.println(toString2());
			//System.out.println();	
			evaluate(copy);
		}
		evaluate(copy);
	}	
	
	public void evaluate(String copy) {
		String o = "*/+-()^";
		if(nums.size() >= 2 && !opps.isEmpty()) {
			if (opps.peek().equals("-")) {
				if(copy.equals("") || (!copy.substring(0, 1).equals("*") && !copy.substring(0, 1).equals("/"))) {
					opps.pop();
					nums.push(-(nums.pop() - nums.pop()));
				}
			} else if (opps.peek().equals("+")) {
				if(copy.equals("") || (!copy.substring(0, 1).equals("*") && !copy.substring(0, 1).equals("/"))) {
					opps.pop();
					nums.push(nums.pop() + nums.pop());
				}
			}
			else if(opps.peek().equals("*")) {
				if(!copy.equals("") && !o.contains(copy.substring(0,1))) {
					return;
				} else if(copy.equals("") || copy.substring(0,1).equals("+") || copy.substring(0,1).equals("-")) {
					nums.push(nums.pop() * nums.pop());
					opps.pop();
				} 
			} 
			else if(opps.peek().equals("/")) {
				if(!copy.equals("") && !o.contains(copy.substring(0,1))) {
					return;
				} else if(copy.equals("") || copy.substring(0,1).equals("+") || copy.substring(0,1).equals("-")) {
					nums.push(1 / (nums.pop() / nums.pop()));
					opps.pop();
				}
			}
		}
	}
	
	public String toString2() {
		String s = "nums: ";
		for (double x : nums) {
			s += x + ", ";
		}
		s += "\nopps: ";
		for (String x : opps) {
			s+= x + ", ";
		}
		return s;
	}
	
	public String toString() {
			return nums.peek() + "";
	}
	
	public static void main(String[] args) {
		Arithmetic one = new Arithmetic("3*5-4+6/2");
		one.processInput();
		System.out.println(one.toString());
		System.out.println();
		Arithmetic two = new Arithmetic("1-6/2");
		two.processInput();
		System.out.println(two.toString());
		System.out.println();
	}
}