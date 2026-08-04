class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int nr = s2.length() + 1;
        int nc = s1.length() + 1;
        boolean[][] dp = new boolean[nr][nc];

        dp[0][0] = true;

        //row 0
        for(int j = 1; j < nc; j++){
            if(dp[0][j - 1] && (s1.charAt(j - 1) == s3.charAt(j - 1))){
                dp[0][j] = true;
            }
        }

        //col 0
        for(int i = 1; i < nr; i++){
            if(dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1))){
                dp[i][0] = true;
            }
        }

        //rest
        for(int i = 1; i < nr; i++){
            for(int j = 1; j < nc; j++){
                //left
                if(dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)))            {
                    dp[i][j] = true;
                }
                //top
                if(dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))            {
                    dp[i][j] = true;
                }
            }
        }


        return dp[nr - 1][nc - 1];
    }
}