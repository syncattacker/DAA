public class MatrixChainMultiplication {   
    public static int matrixChainOrder(int[] p) {   
        int n = p.length;   
        int[][] dp = new int[n][n];   
        for (int l = 2; l < n; l++) {   
            for (int i = 1; i < n - l + 1; i++) {   
                int j = i + l - 1;   
                dp[i][j] = Integer.MAX_VALUE;   
                for (int k = i; k < j; k++) {   
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];   
                    if (cost < dp[i][j]) {   
                        dp[i][j] = cost;   
                    }   
                }   
            }   
        }   
        return dp[1][n - 1];   
    }   
    public static void main(String[] args) {   
        int[] dimensions = {1, 2, 3, 4};   
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(dimensions));   
    }   
}   