class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int nr = s2.length() + 1;
        int nc = s1.length() + 1;
        int[][] dp = new int[nr][nc];

        for(int j = 1; j < nc; j++){
            int left = dp[0][j - 1];
            dp[0][j] = left + s1.charAt(j - 1);
        }
        for(int i = 1; i < nr; i++){
            int top = dp[i - 1][0];
            dp[i][0] = top + s2.charAt(i - 1);
        }       
        for(int i = 1; i < nr; i++){
            for(int j = 1; j < nc; j++){
                if(s2.charAt(i - 1) == s1.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int top = dp[i - 1][j] + s2.charAt(i - 1);
                    int left = dp[i][j - 1] + s1.charAt(j - 1);
                    dp[i][j] = Math.min(top, left);
                }
            }
        }
        return dp[nr - 1][nc - 1];
    }
}