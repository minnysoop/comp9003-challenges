import java.util.Scanner;

public class MatrixMult {
	
	public static int[][] mult(int[][] A, int[][] B) {
        int n = A.length;
        int l = A[0].length;
        int p = B[0].length;
        int[][] result = new int[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < l; k++) {
                    result[i][j] += A[i][k]*B[k][j];
                }
            }
        }

        return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int colA_dim = s.nextInt();
        int rowA_dim = s.nextInt();
        int colB_dim = s.nextInt();
        int rowB_dim = s.nextInt();
        int[][] A = new int[rowA_dim][colA_dim];
        int[][] B = new int[rowB_dim][colB_dim];

        if (rowA_dim == 0 || rowB_dim == 0) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < rowA_dim; i++) {
            for (int j = 0; j < colA_dim; j++) {
                A[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < rowB_dim; i++) {
            for (int j = 0; j < colB_dim; j++) {
                B[i][j] = s.nextInt();
            }
        }

        if (A == null || B == null || colA_dim != rowB_dim) {
            System.out.println("Invalid input.");
            return;
        }

        int[][] result = mult(A, B);

        for (int i = 0;i < result.length; i++) {
            for (int j = 0;j < result[0].length; j++){
                if (j == result[0].length-1) {
                    System.out.print(result[i][j]);
                }
                else {
                    System.out.print(result[i][j] + " ");
                }
                
            }
            System.out.println();
        }
	}
	
}
