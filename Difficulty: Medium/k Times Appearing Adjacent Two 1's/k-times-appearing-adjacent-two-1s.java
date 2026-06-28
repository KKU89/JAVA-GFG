class Solution {
    public int countStrings(int n, int k) {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][k + 1][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i + 1][j][0] = (dp[i][j][0] + dp[i][j][1]) % mod;
                
                dp[i + 1][j][1] = (dp[i + 1][j][1] + dp[i][j][0]) % mod;
                
                if (j + 1 <= k) {
                    dp[i + 1][j + 1][1] = (dp[i + 1][j + 1][1] + dp[i][j][1]) % mod;
                }
            }
        }

        return (dp[n][k][0] + dp[n][k][1]) % mod;
    }
}