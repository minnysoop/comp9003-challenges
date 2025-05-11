import java.util.Scanner;

public class Nforce {
	public static void printCone(int tier, int outer_space, int inner_space) {
		StringBuilder b = new StringBuilder("");
		for (int i = 0; i < outer_space; i++) {
			b.append(" ");
		}
		b.append("/");
		for (int i = 0; i < inner_space*2; i++) {
			b.append(" ");
		}
		b.append("\\");

		for (int i = 0; i < outer_space; i++) {
			b.append(" ");
		}

		StringBuilder r = new StringBuilder("");
		for (int i = 0; i < tier; i++) {
			r.append(b);
		}
		System.out.println(r.toString().replaceAll("\\s+$", ""));
	}

	public static void printBase(int tier, int height) {
		int n = 2*(height-1);
		StringBuilder b = new StringBuilder("/");
		for (int i = 0; i < n; i++) {
			b.append('_');
		}
		b.append('\\');

		StringBuilder r = new StringBuilder("");

		for (int i = 0; i < tier; i++) {
			r.append(b);
		}

		System.out.println(r.toString().replaceAll("\\s+$", ""));
	}

	public static void triforce(int height, int tier) {
		int c = tier-1;
		for (int i = 1; i <= tier; i++) {
			int offset = c*height;
			for (int j = 0; j < height-1; j++) {
				for (int k = 0; k < offset; k++) {
					System.out.print(" ");
				}
				printCone(i, height-j-1, j);
			}

			for (int k = 0; k < offset; k++) {
				System.out.print(" ");
			}
			printBase(i, height);
			c--;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter height: ");
		try {
			int a = scanner.nextInt();
			if (a < 1 || a > 20) {
				System.out.println();
				System.out.println("Invalid height.");
				return;
			}
			System.out.print("Enter number of rows: ");
			try {
				int b = scanner.nextInt();
				if (b < 1 || b > 20) {
					System.out.println();
					System.out.println("Invalid number of rows.");
					return;
				}
				System.out.println();
				triforce(a, b);
			} catch (Exception e) {
				System.out.println();
				System.out.println("Invalid number of rows.");
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Invalid height.");
		}
		
	}
}
