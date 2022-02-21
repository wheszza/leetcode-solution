/*
 * @Author: whe
 * @Date: 2022-02-21 17:29:26
 */
public class _02211 {
    //动态规划
    public int maximalSquare(char[][] matrix) {
        int side = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    side = Math.max(side, dp[i][j]);
                }
            }
        }
        return side * side;
    }
    /* 前缀和
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - '0'- preSum[i - 1][j - 1];
            }
        }
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                int l = 0;
                int sum = 0;
                while (sum == l * l ){
                    if (sum > ans) ans = sum;
                    l++;
                    if (i + l > m || j + l > n) break;
                    sum = preSum[i + l][j + l] + preSum[i][j] - preSum[i + l][j] - preSum[i][j + l];
                }
            }
        }
        return ans;
    }
    */
}
