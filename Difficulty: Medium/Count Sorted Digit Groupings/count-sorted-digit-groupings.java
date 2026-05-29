import java.util.Arrays;

class Solution {
    private int[][] dp;

    public int validGroups(String s) {
        int n = s.length();
        dp = new int[n][901];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s);
    }

    private int solve(int index, int prevSum, String s) {
        if (index == s.length()) {
            return 1;
        }
        if (dp[index][prevSum] != -1) {
            return dp[index][prevSum];
        }

        int currentSum = 0;
        int ways = 0;

        for (int i = index; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';
            if (currentSum >= prevSum) {
                ways += solve(i + 1, currentSum, s);
            }
        }

        return dp[index][prevSum] = ways;
    }
}