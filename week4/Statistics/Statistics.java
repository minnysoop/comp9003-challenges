import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class Statistics {
	
	// Returns the mean of the given data set.
	public static double mean(ArrayList<Double> numbers) {
		double sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
 		return sum/numbers.size();
	}
	
	// Returns the variance of the given data set.
	public static double variance(ArrayList<Double> numbers, double mean) {
		double sum_of_diff = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum_of_diff += Math.pow(numbers.get(i) - mean, 2);
		}
		return sum_of_diff/numbers.size();
	}
	
	// Returns the standard deviation of the given data set.
	public static double sd(double variance) {
		return Math.sqrt(variance);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Double>data = new ArrayList<Double>(1);
		System.out.println("Enter data set:");
		while (scanner.hasNextDouble()) {
			double t = scanner.nextDouble();
			data.add(t);
		}
		System.out.println();
		if (data.size() == 0) {
			System.out.println("No data!");
			return;
		}
		double avg = mean(data);
		double variance = variance(data, avg);
		double standard_deviation = sd(variance);
		System.out.printf("Mean = %.4f\n", avg);
		System.out.printf("Variance = %.4f\n", variance);
		System.out.printf("Standard deviation = %.4f\n", standard_deviation);
	} 
}
