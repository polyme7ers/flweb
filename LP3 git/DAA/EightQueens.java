public class EightQueens {

    static final int N = 8;

    // Function to print the chessboard
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // Check if a queen can be placed at board[row][col]
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check column above
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper right diagonal
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Backtracking function to solve 8-Queens
    static boolean solveNQUtil(int board[][], int row) {
        // Base case: if all queens are placed
        if (row == N)
            return true;

        // Try placing this queen in all columns
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;  // Place queen

                // Recur for next row
                if (solveNQUtil(board, row + 1))
                    return true;

                // Backtrack if placing queen here doesn’t lead to a solution
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int board[][] = new int[N][N];

        // First Queen already placed at (0,0)
        board[0][0] = 1;

        // Start solving from the second row
        if (!solveNQUtil(board, 1)) {
            System.out.println("Solution does not exist");
            return;
        }

        printSolution(board);
    }
}









//////////////////input code-----------------------------------------------
/// 
/// import java.util.Scanner;

// public class EightQueensInput {

//     static final int N = 8;

//     // Function to print the chessboard
//     static void printSolution(int board[][]) {
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++)
//                 System.out.print(board[i][j] + " ");
//             System.out.println();
//         }
//     }

//     // Check if a queen can be placed at board[row][col]
//     static boolean isSafe(int board[][], int row, int col) {
//         int i, j;

//         // Check column above
//         for (i = 0; i < row; i++)
//             if (board[i][col] == 1)
//                 return false;

//         // Check upper left diagonal
//         for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
//             if (board[i][j] == 1)
//                 return false;

//         // Check upper right diagonal
//         for (i = row, j = col; i >= 0 && j < N; i--, j++)
//             if (board[i][j] == 1)
//                 return false;

//         return true;
//     }

//     // Backtracking function to solve N Queens
//     static boolean solveNQUtil(int board[][], int row) {
//         if (row == N)
//             return true;

//         for (int col = 0; col < N; col++) {
//             if (isSafe(board, row, col)) {
//                 board[row][col] = 1;

//                 if (solveNQUtil(board, row + 1))
//                     return true;

//                 board[row][col] = 0; // backtrack
//             }
//         }
//         return false;
//     }

//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         int board[][] = new int[N][N];

//         // Take input for first queen's position
//         System.out.print("Enter row (0-7) for first Queen: ");
//         int row = sc.nextInt();
//         System.out.print("Enter column (0-7) for first Queen: ");
//         int col = sc.nextInt();

//         // Validate input
//         if (row < 0 || row >= N || col < 0 || col >= N) {
//             System.out.println("Invalid position! Please enter values between 0 and 7.");
//             return;
//         }

//         // Place the first queen
//         board[row][col] = 1;

//         // Try to place remaining queens
//         if (!solveNQUtil(board, 0)) {
//             System.out.println("Solution does not exist");
//         } else {
//             System.out.println("\nFinal 8-Queens Matrix:");
//             printSolution(board);
//         }

//         sc.close();
//     }
// }
