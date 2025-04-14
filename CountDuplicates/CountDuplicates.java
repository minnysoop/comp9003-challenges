import java.util.Arrays;

public class CountDuplicates {
	public static int countDuplicates(int[] a) {
		if (a == null) return 0;
		Arrays.sort(a);
		int duplicates = 0;

		int counter = 0;
		int current = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] == current) {
				counter++;
			} else if (counter > 0) {
				duplicates++;
				counter = 0;
				current = a[i];
			} else {
				current = a[i];
			}
		}

		if (counter > 0) duplicates++;

		return duplicates;
	}
	
	public static void main(String[] args) {
		int[] dups = {1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8, 9};
		// 1, 1, 1, 2, 3, 5, 5, 6, 8, 8, 9
		int result = countDuplicates(dups); //3
		System.out.println(result);
	}
	
}
