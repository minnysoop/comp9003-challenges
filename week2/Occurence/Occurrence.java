import java.util.Scanner;

public class Occurrence {
	
	public static void main(String[] args) {
		int[] freq = new int[10];
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		scanner.close();
		
		for (int i = 0; i < a.length(); i++) {
			if (Character.isDigit(a.charAt(i))) {
                freq[a.charAt(i) - '0']++; 
            }
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " + freq[i]);
		}
	}
	
}
