//package lp3_daa;

import java.util.Scanner;

public class knapdp {

    // Function to solve 0-1 Knapsack problem
    static int knapsack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // The last cell contains the maximum profit
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        int maxVal = knapsack(W, wt, val, n);
        System.out.println("\nMaximum total value in knapsack = " + maxVal);

        sc.close();
    }
}
