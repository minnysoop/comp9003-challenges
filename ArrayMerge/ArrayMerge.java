public class ArrayMerge{
	public static int[][] mergeArrays(int[][] arrayA, int[][] arrayB){
		int n = arrayA.length;
		int m = arrayA[0].length + arrayB[0].length;

		int[][] result = new int[n][m];
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < arrayA[0].length; j++) {
				result[i][j] = arrayA[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arrayB[0].length; j++) {
				result[i][j + arrayA[0].length] = arrayB[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] A = {
            {1, 9, 7, 2, 3},
            {0, 7, 8, 3, 2},
            {3, 8, 9, 7, 2}
        };

		int[][] B = {
            {1, 2, 3, 3},
            {3, 2, 1, 6},
            {4, 5, 6, 1}
        };

		mergeArrays(A, B);
	}
}
