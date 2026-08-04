class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                dp[i][j] = left + top;
            }
        }
        return dp[m - 1][n - 1];
    }
}