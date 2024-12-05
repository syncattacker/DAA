import java.util.Scanner;   
public class SubsetSum {   
    public static boolean isSubsetSum(int[] set, int sum) {   
        int n = set.length;   
        boolean[][] dp = new boolean[n + 1][sum + 1];   
        for (int i = 0; i <= n; i++)   
            dp[i][0] = true;   
        for (int i = 1; i <= n; i++) {   
            for (int j = 1; j <= sum; j++) {   
                if (set[i - 1] <= j)   
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];   
                else   
                    dp[i][j] = dp[i - 1][j];   
            }   
        }   
        return dp[n][sum];   
    }   
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);   
        System.out.print("Enter the number of elements: ");   
        int n = sc.nextInt();   
        int[] set = new int[n];   
        System.out.println("Enter the elements: ");   
        for (int i = 0; i < n; i++)   
            set[i] = sc.nextInt();   
        System.out.print("Enter the sum: ");   
        int sum = sc.nextInt();   
        System.out.println("Is subset with given sum possible? " + isSubsetSum(set, sum));   
    }   
}   