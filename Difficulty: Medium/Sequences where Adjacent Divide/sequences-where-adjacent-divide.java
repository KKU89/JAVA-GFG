class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int curr = 1; curr <= m; curr++) {
                for (int prev = 1; prev <= m; prev++) {
                    if (curr % prev == 0 || prev % curr == 0) {
                        dp[i][curr] += dp[i - 1][prev];
                    }
                }
            }
        }
        
        int total = 0;
        for (int j = 1; j <= m; j++) {
            total += dp[n][j];
        }
        
        return total;
    }
}