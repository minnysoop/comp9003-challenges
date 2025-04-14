import java.util.Scanner;

public class Barcode {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		int sum_odd = 0; 
		// Sum digits in odd positions
		for (int i = 0; i < input.length(); i += 2) {
			sum_odd += input.charAt(i) - '0';
		}

		// Multiply the result by 3
		sum_odd *= 3;

		int sum_even = 0;
		// Sum digits in even positions
		for (int i = 1; i < input.length()-1; i += 2) {
			sum_even += input.charAt(i) - '0';
		}
		
		// Add to result
		sum_odd += sum_even;

		// Subtract result from 10
		int expected_check_digit = 10 - sum_odd%10;

		boolean matches = expected_check_digit%10 == input.charAt(input.length()-1) - '0';
		if (matches) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
	}
}
