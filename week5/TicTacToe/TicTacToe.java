import java.util.Scanner;

public class TicTacToe {
    private static void printBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) System.out.print("|");
                if (board[i][j] == 0) System.out.print(" ");
                if (board[i][j] == 1) System.out.print("X");
                if (board[i][j] == -1) System.out.print("O");
                if (j == 0) System.out.print("|");
            }

            if (i < 2) {
                System.out.println();
                System.out.println("-----");
            }
        }
        System.out.println();
    }

    private static boolean isWin(int[][] board, int turn){
        return (board[0][0] == turn && board[0][1] == turn && board[0][2] == turn) || 
               (board[1][0] == turn && board[1][1] == turn && board[1][2] == turn) ||
               (board[2][0] == turn && board[2][1] == turn && board[2][2] == turn) ||

               (board[0][0] == turn && board[1][0] == turn && board[2][0] == turn) ||
               (board[0][1] == turn && board[1][1] == turn && board[2][1] == turn) ||
               (board[0][2] == turn && board[1][2] == turn && board[2][2] == turn) ||

               (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) ||
               (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn);
    }

    private static void tictactoe() {
        int[][] board = new int[3][3];
        int turn = 1;
        int num = 1;
        boolean inProgress = true;
        Scanner s = new Scanner(System.in);
        while (inProgress) {
            int row = s.nextInt();
            int column = s.nextInt();

            board[column][row] = turn;

            if (isWin(board, turn)) {
                if (turn == 1) System.out.println("X wins!");
                if (turn == -1) System.out.println("O wins!");
                System.out.println();
                printBoard(board);
                System.out.println();
                break;
            }
            
            num++;
            if (num == 10) {
                System.out.println("Draw");
                System.out.println();
                printBoard(board);
                System.out.println();
                break;
            }

            System.out.println();
            printBoard(board);
            System.out.println();

            if (turn == 1) {
                turn = -1;
            } else {
                turn = 1;
            }

        }
     }

    public static void main(String[] args) {
        tictactoe();
    }
}
