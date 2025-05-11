public class Count {
	
	public static int count(int[] array, int element) {
		int accumulator = 0;
		try {
			int n = array.length;
			for (int i = 0; i < n; i++){
				if (array[i] == element) {
					accumulator++;
				}
			}
			return accumulator;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
