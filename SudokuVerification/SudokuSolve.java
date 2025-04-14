public class SudokuSolve {
	
	public static boolean isSolvable(Integer[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

		int n = board.length;
		int m = board[0].length;
		if (n % 3 != 0 || m % 3 != 0 || !isValidBoard(board)) {
			return false;
		}
		return solve(board);
	}

	public static boolean solve(Integer[][] board) {
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == null) {
					for (int p = 1; p <= 9; p++) {
						if (isValid(board, i, j, p)) {
							board[i][j] = p;
							if (solve(board)) {
								return true;
							}
							board[i][j] = null;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(Integer[][] board, int row, int col, int num) {
		int n = board.length;
		int m = board[0].length;
		// Row
		for (int i = 0; i < m; i++) {
			if (board[row][i] != null && board[row][i] == num) {
				return false;
			} 
		}

		// Column 
		for (int i = 0; i < n; i++) {
			if (board[i][col] != null && board[i][col] == num) {
				return false;
			}
		}

		// Subgrid
		int subgrid_row = n;
		int subgrid_col = m; 
		int sizeOfP = 3;
		int numOfRowP = m/3;
		int numOfColP = n/3;

		// Find i-th partition
		for (int i = 0; i < numOfRowP; i++) {
			if (col < sizeOfP*i + sizeOfP) {
				subgrid_row = i;
				break;
			}
		} 
		// Find j-th parition
		for (int i = 0; i < numOfColP; i++) {
			if (row < sizeOfP*i + sizeOfP) {
				subgrid_col = i;
				break;
			}
		}

		// Loop grid bounded by this box
		for (int i = sizeOfP*subgrid_row; i < sizeOfP*subgrid_row + sizeOfP; i++) {
			for (int j = sizeOfP*subgrid_col; j < sizeOfP*subgrid_col + sizeOfP; j++) {
				if (board[i][j] != null && board[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}

	private static boolean isValidBoard(Integer[][] board) {
		int n = board.length;
		int m = board[0].length;

		// Check every row
		for (int i = 0; i < n; i++) {
			boolean[] seen = new boolean[9];
			for (int j = 0; j < m; j++) {
				if (board[i][j] != null) {
					if (seen[board[i][j]-1]) {
						return false;
					}
					seen[board[i][j]-1] = true;
				}
			}
		}

		// Check every col
		for (int j = 0; j < m; j++) {
			boolean[] seen = new boolean[9];
			for (int i = 0; i < n; i++) {
				if (board[i][j] != null) {
					if (seen[board[i][j]-1]) {
						return false;
					}
					seen[board[i][j]-1] = true;
				}
			}
		}

		// Check every 3x3 subgrid
		int sizeOfP = 3;
		int numOfRowP = m/3;
		int numOfColP = n/3;

		for (int i = 0; i < numOfRowP; i++) {
			for (int j = 0; j < numOfColP; j++) {
				boolean[] seen = new boolean[9]; 
				for (int k = sizeOfP*i; k < sizeOfP*i + sizeOfP; k++) {
					for (int l = sizeOfP*j; l < sizeOfP*j + sizeOfP; l++) {
						if (board[k][l] != null) {
							if (seen[board[k][l]-1]) {
								return false;
							}
							seen[board[k][l]-1] = true;
						}
					}
				}

			}
		}

		return true;
	}

	
	public static void main(String[] args) {
		//Write some tests if you want check here or change b
		Integer[][] b = { 
				{ 1, 2, 3},
				{ 4, 5, 6},
				{ 7, 8, 9}
			};
		
		if(isSolvable(b)) {
			System.out.println("Yes this is solvable!");
		}
	}
	
}



