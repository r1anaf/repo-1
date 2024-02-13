/*
 * Name: Riana Fazir
 * Project Name: LoopingFun
 * Description: complete various methods, involving the Math and String classes, using loops
 */


public class LoopingFun {

	public static boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}

	public static void primeNumberList(int n) {
		for(int i = 2; i < n; i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}

	public static int sumInts(int n) {
		int sum = 0;
		for (int i = n; i>0; i--) {
			sum += i;
		}
		return sum;
	}

	public static long factorial(int n) {
		long f = 1;
		for (int i = n; i>0; i--) {
			f *= i;
		}
		return f;
	}

	public static boolean isEven(int n) {
		return (n%2==0);
	}

	public static int lcm(int a, int b) {
		for (int i = 1; i<= b; i++) {
			if (i*a % b == 0)
				return i*a;
		}
		return a*b;
	}

	public static int gcf(int a, int b) {
		int max = Math.max(a,b);
		int min = Math.min(a, b);
		for (int i = 2; i<= max; i++) {
			if (max%(min/i) == 0)
				return min/i;
				
		}
		return max/min;
	}

	public static int sumDigits(int n) {
		int sum = 0;
		int digit = 0;
		for (int i = 0; i < (n+"").length(); i++) {
			digit = (int) ((n/(Math.pow(10, i)))%10);
			sum+=digit;
		}
		return sum;
	}
	

	public static int reverseNum(int n) {
		String a = n+"";
		String r = "";
		for (int i = a.length(); i > 0; i--) {
				r += a.substring(i-1, i);
		}
		return Integer.parseInt(r);
	}

	public static void coinTrials(int n) {
		int h = 0;
		int t = 0;
		int ran;
		for (int i = 0; i<n; i++) {
			ran = (int)(Math.random() * 2);
			if (ran==1)
				h++;
			else
				t++;
		}
		System.out.println("Heads: " + h + "\t" + ((double)h) + "%");
		System.out.println("Tails: " + t + "\t" + ((double)t) + "%");
	}

	public static int countDigits(int n) {
		String a = n+"";
		return a.length();
	}

	public static void fibonacci(int n) {
		int n1 = 0;
		int n2 = 1;
		System.out.print(n2 + " ");
		for (int i = 1; i<n-1; i+=2) {
			n1 = n1 + n2;
			System.out.print(n1+" ");
			n2 = n2+ n1;
			System.out.print(n2+" ");
		}
		n1 = n1 + n2;
		System.out.print(n1+" ");
	}

	public static boolean isPerfect(int n) {
		int add = 0;
		for(int i = 1; i < n; i++) {
			if(n%i == 0)
				add+=i;
		}
		return (add==n);
		
	}

	public static void primeFactorization(int n) {
		while (n%2==0) {
			System.out.print(2 + " ");
			n/=2;
		}
		for (int i = 3; i <= n; i++) {
			if (n%i==0) {
				System.out.print(i + " ");
				n/= i;
			}
		}
	}

	public static int binary(int n) {
		int a;
		String b="";
		while (n!=0) {
			a = n%2;
			if (a==0) 
				b+="0";
			else
				b+="1";
			n/=2;
		}
		String rb = "";
		for (int i = b.length()-1; i>=0; i--) {
			rb += b.charAt(i);
		}
		return Integer.parseInt(rb);
	}

	public static void pyramid(int n) {
		for (int i = 1; i<=n; i++) {
			for (int j = i; j<= n-1; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k<=2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public static void printFactors1(int n) {
		for(int i = 1; i < n; i++) {
			if(n%i == 0)
				System.out.print(i + " ");
		}
		System.out.println(n);
	}

	public static void printFactors2(int n) {
		int i = 1;
		while (i < n) {
			if(n%i == 0)
				System.out.print(i + " ");
			i++;
		}
		System.out.println(n);
	
	}

	public static void main(String[] args) {
		System.out.println("Riana Fazir\n");
		
		System.out.println("Binary of 122:  " + binary(122));
		System.out.println("\nCoin trials:  ");
		coinTrials(100);
		System.out.println("\nCountDigits of 23456:  " + countDigits(23456));
		System.out.println("\nFactorial of 10:  " + factorial(10));
		System.out.println("\nFibonacci of 10:  ");
		fibonacci(10);
		System.out.println("\n\ngcf of 32 & 80:  " + gcf(32, 80));
		System.out.println("\nisEven of 62875:  " + isEven(62875));
		System.out.println("isEven of 62878:  " + isEven(62878));
		System.out.println("\nisPerfect of 28:  " + isPerfect(28));
		System.out.println("isPerfect of 30:  " + isPerfect(30));
		System.out.println("\nisPrime of 30:  " + isPrime(30));
		System.out.println("isPrime of 31:  " + isPrime(31));
		System.out.println("\nlcm of 32 & 80:  " + lcm(32, 80));
		System.out.println("\nPrime Factorization of 112:  ");
		primeFactorization(112);
		System.out.println("\n\nPrime number list for 34:  ");
		primeNumberList(34);
		System.out.println("\n\nReverse of 1358642:  " + reverseNum(1358642));
		System.out.println("\nPyramid - 6 high:  ");
		pyramid(6);
		System.out.println("\nsum digits of 24678:  " + sumDigits(24678));
		System.out.println("\nsum of ints up to 10:  " + sumInts(10));
		System.out.println("\nFactors of 84:  ");
		printFactors1(84);
		System.out.println("Factors of 100:  ");
		printFactors2(100);
	}
}
