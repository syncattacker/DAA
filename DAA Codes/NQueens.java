import java.util.Scanner;   
public class NQueens {   
    public static void solveNQueens(int[][] board, int row, int n) {   
        if (row == n) {   
            printBoard(board, n);   
            return;   
        } 
        for (int col = 0; col < n; col++) {   
            if (isSafe(board, row, col, n)) {   
                board[row][col] = 1;   
                solveNQueens(board, row + 1, n);   
                board[row][col] = 0; // backtrack   
            }   
        }   
    }
    public static boolean isSafe(int[][] board, int row, int col, int n) {   
        for (int i = 0; i < row; i++)   
            if (board[i][col] == 1)   
                return false;   
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)   
            if (board[i][j] == 1)   
                return false;
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)   
            if (board[i][j] == 1)   
                return false;   
        return true; 
    }
    public static void printBoard(int[][] board, int n) {   
        for (int i = 0; i < n; i++) {   
            for (int j = 0; j < n; j++) {   
                System.out.print(board[i][j] + " ");   
            }   
            System.out.println();   
        }   
        System.out.println();   
    }
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);   
        System.out.print("Enter the number of queens: ");   
        int n = sc.nextInt();   
        int[][] board = new int[n][n];   
        solveNQueens(board, 0, n);   
    }   
}   