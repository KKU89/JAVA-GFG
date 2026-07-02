class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;
        if (n > k) return true;
        boolean[] dp = new boolean[k];
        for (int x : arr) {
            boolean[] next = new boolean[k];
            next[x % k] = true;
            for (int i = 0; i < k; i++) {
                if (dp[i]) {
                    next[i] = true;
                    next[(i + x) % k] = true;
                }
            }
            dp = next;
            if (dp[0]) return true;
        }
        return dp[0];
    }
}