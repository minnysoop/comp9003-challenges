public class Contains {
	
	public static boolean contains(int[] a, int element) {
		if (a == null) return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == element) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
	
}
