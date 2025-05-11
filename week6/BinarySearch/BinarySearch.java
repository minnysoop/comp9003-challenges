import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuilder;

public class BinarySearch {
	
	public static int[] readFile(String filename) {
		StringBuilder arr_as_str = new StringBuilder("");
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				arr_as_str.append(scanner.next()).append(" ");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		String[] tmp = arr_as_str.toString().split(" ");
		int[] out = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			out[i] = Integer.parseInt(tmp[i]);
		}
		return out;
	}
	
	public static Integer binarySearch(int low, int high, int search, int[] array) {
		if (low > high) { return null; } 
		int mid = (low + high)/2;
		if (array[mid] == search) { return array[mid]; } 
		else if (array[mid] < search){ return binarySearch(mid+1, high, search, array);} 
		else { return binarySearch(low, mid-1, search, array); }
	}
	
	public static void main(String[] args) {
		int num_to_search_for = Integer.parseInt(args[0]);
		int[] num_array = readFile(args[1]);
		Arrays.sort(num_array);
		Integer res = binarySearch(0, num_array.length-1, num_to_search_for, num_array);
		if (res != null) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
		
	}
}
