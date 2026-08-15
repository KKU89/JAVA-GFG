class Solution {
    public int countWithout(int n, int d) {
        if (n <= 0) return 0;
        String s = Integer.toString(n);
        int len = s.length();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // dp[pos][tight][started]  -  memoization
        Integer[][][] dp = new Integer[len][2][2];

        return dfs(0, 1, 0, digits, d, dp);
    }

    private int dfs(int pos, int tight, int started, int[] digits, int d, Integer[][][] dp) {
        if (pos == digits.length) {
            return started == 1 ? 1 : 0;
        }
        if (dp[pos][tight][started] != null) {
            return dp[pos][tight][started];
        }

        int limit = (tight == 1) ? digits[pos] : 9;
        int ans = 0;

        for (int dig = 0; dig <= limit; dig++) {
            int ntight = (tight == 1 && dig == digits[pos]) ? 1 : 0;

            if (started == 0 && dig == 0) {
                // leading zero, ignore digit d
                ans += dfs(pos + 1, ntight, 0, digits, d, dp);
            } else {
                // actual digit of the number
                if (dig == d) continue;
                ans += dfs(pos + 1, ntight, 1, digits, d, dp);
            }
        }

        dp[pos][tight][started] = ans;
        return ans;
    }
}