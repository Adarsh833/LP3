public class EightQueens {
    static final int N = 8; 
    static int[][] board = new int[N][N]; 

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static boolean solveNQUtil(int row) {
        if (row >= N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1; 

                if (solveNQUtil(row + 1)) {
                    return true;
                }

                board[row][col] = 0; 
            }
        }

        return false; 
    }

    public static void main(String[] args) {
        board[0][0] = 1; 
        if (solveNQUtil(1)) { 
            printBoard();
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
