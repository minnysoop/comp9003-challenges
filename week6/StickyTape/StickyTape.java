import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class StickyTape {

	public static void main(String[] args) {
		int num_of_args = args.length;
		int max_words = 0;

		HashMap<Integer, ArrayList<String>>mp = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < num_of_args; i++) {
			try {
				File file = new File(args[i]);
				Scanner scanner = new Scanner(file);
				int num_words = 0;
				while (scanner.hasNextLine()) {
					if (mp.containsKey(i)) {
						mp.get(i).add(scanner.nextLine());
					} else {
						ArrayList<String>t = new ArrayList<String>();
						t.add(scanner.nextLine());
						mp.put(i, t);
					}
					num_words++;
				}
				if (num_words > max_words) {
					max_words = num_words;
				}
			} catch (FileNotFoundException e) {
				System.out.printf("Unable to load file %s\n", args[i]);
				return;
			}
		}

		String out = "";
		for (int i = 0; i < max_words; i++) {
			for (int j = 0; j < num_of_args; j++) {
				if (mp.get(j).size() > i) {
					out += mp.get(j).get(i);
				}

				if (j < num_of_args-1) out += "\t";
			}
			out += "\n";
		}

		System.out.print(out);
	}
}
