import java.util.Scanner;
import java.lang.Math;

public class GoldenRatio {
	private final static double gamma = 1.6181;
	private final static double epsilon = 0.001;

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			System.out.print("Enter two numbers: ");
			double a = s.nextDouble();
			double b = s.nextDouble();

			if (a < b) {
				double tmp = a;
				a = b;
				b = tmp;
			}

			double r = a/b;
			if (Math.abs(r - gamma) <= epsilon) {
				System.out.println("\nGolden ratio!");
			} else {
				System.out.println("\nMaybe next time.");
			}
		} catch(Exception e) {
			System.out.println("\nInvalid input.");
		}
	}
}
