public class WhichPartition {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int index = 8;
		
		int n = A.length;
		int numOfParitions = n/3;
		int sizeOfPartition = 3;
		
		for (int i = 0; i < numOfParitions; i++) {
			if (index < 3*i + sizeOfPartition) {
				System.out.println(i);
				break;
			}
		}	
		return;
	}
}
