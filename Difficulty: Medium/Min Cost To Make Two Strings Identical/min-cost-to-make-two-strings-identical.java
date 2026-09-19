class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int n = x.length(), m = y.length();
        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        int lcs = dp[m];
        return n * costX + m * costY - lcs * (costX + costY);
    }

    public int minCost(String s1, String s2, int costS1, int costS2) {
        return findMinCost(s1, s2, costS1, costS2);
    }
}