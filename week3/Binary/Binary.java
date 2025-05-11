Bimport java.util.Scanner;

public class Binary {

	// Returns decimal representation of given binary number.
	public static int toDecimal(String b) {
		int dec = 0;
		int n = b.length();
		int exp = 0;
		for (int i = n-1; i >= 0; i--) {
			dec += (int)(b.charAt(i)-'0')*(int)Math.pow(2,exp);
			exp++;
		}
		return dec;
	}

	// Returns whether or not given string is a binary number.
	public static boolean isBinary(String b) {
		int n = b.length();
		for (int i = 0; i < n; i++) {
			if (b.charAt(i) != '0' && b.charAt(i) != '1') return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter binary: ");
		String in = scanner.nextLine();
		System.out.println();
		if (Binary.isBinary(in)) {
			int d = Binary.toDecimal(in);
			System.out.println(d + " in decimal");
		} else {
			System.out.println("Not binary!");
		}
	}
}
