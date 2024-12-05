import java.util.Scanner;   
public class Knapsack {   
    public static int knapsack(int[] weights, int[] values, int W) {   
        int n = values.length;   
        int[][] dp = new int[n + 1][W + 1];   
        for (int i = 1; i <= n; i++) {   
            for (int w = 1; w <= W; w++) {   
                if (weights[i - 1] <= w)   
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);   
                else   
                    dp[i][w] = dp[i - 1][w];   
            }   
        }      
        return dp[n][W];   
    }   

    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);   
        System.out.print("Enter the number of items: ");   
        int n = sc.nextInt();   
        int[] values = new int[n];   
        int[] weights = new int[n];   
        System.out.println("Enter the values of the items: ");   
        for (int i = 0; i < n; i++)   
            values[i] = sc.nextInt();   
        System.out.println("Enter the weights of the items: ");   
        for (int i = 0; i < n; i++)   
            weights[i] = sc.nextInt();   
        System.out.print("Enter the maximum weight capacity: ");   
        int W = sc.nextInt();   
        System.out.println("Maximum value in knapsack: " + knapsack(weights, values, W));   
    }   
}   