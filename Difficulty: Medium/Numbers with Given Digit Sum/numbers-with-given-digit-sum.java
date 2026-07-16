class Solution {
    public int countWays(int n, int sum) {
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }
        
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        
        long ans = 0;
        for (int i = 1; i <= 9; i++) {
            if (sum - i >= 0) {
                ans += solve(n - 1, sum - i, dp);
            }
        }
        
        return ans == 0 ? -1 : (int) ans;
    }
    
    private int solve(int n, int sum, int[][] dp) {
        if (sum < 0) return 0;
        if (n == 0) return sum == 0 ? 1 : 0;
        if (dp[n][sum] != -1) return dp[n][sum];
        
        long ways = 0;
        for (int i = 0; i <= 9; i++) {
            if (sum - i >= 0) {
                ways += solve(n - 1, sum - i, dp);
            }
        }
        return dp[n][sum] = (int) ways;
    }
}