import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			String[] s = input.split(" ");

			int n = s.length/2;
			int c = 0;
			for (int i = 0; i < n; i++) {
				String t = s[i];
				s[i] = s[s.length-1-c];
				s[s.length-1-c] = t;
				c++;
			}

			for (int i = 0; i < s.length ; i++) {
				StringBuilder tmp_string = new StringBuilder(s[i]);
				tmp_string.reverse();
				s[i] = tmp_string.toString();
			}

			String output = String.join(" ", s);

			System.out.println(output);
		}
	}
}
