public class ArrayUnion {

	public static boolean contains(int[] a, int element) {
		if (a == null) return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == element) return true;
		}
		return false;
	}
	
	public static int[] union(int[] a, int[] b) {
		if (a == null || b == null) return null;

		int[] result = new int[a.length + b.length];
		int curr = 0;

		for (int i = 0; i < a.length; i++) {
			if (!contains(result, a[i])){
				result[curr] = a[i];
				curr++;
			}
		}

		for (int j = 0; j < b.length; j++) {
			if (!contains(result, b[j])) {
				result[curr] = b[j];
				curr++;
			}
		}

		if (curr != result.length) {
			int[] r = new int[curr];
			for (int i = 0; i < curr; i++) {
				r[i] = result[i];
			}
			return r;
		}

		return result;
	}
	
	
	public static void main(String[] args) {
		int[] x = {2, 2, 7};
		int[] y = {1, 9};

		int[] result = union(x, y);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
}
