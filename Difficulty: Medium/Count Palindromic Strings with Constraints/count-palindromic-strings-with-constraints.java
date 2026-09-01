class Solution {
    public int palindromicStrings(int n, int k) {
        final long MOD = 1000000007L;
        long ans = 0;
        for (int len = 1; len <= n; len++) {
            int half = (len + 1) / 2;
            long ways = 1;
            for (int i = 0; i < half; i++) {
                ways = (ways * (k - i)) % MOD;
            }
            ans = (ans + ways) % MOD;
        }
        return (int) ans;
    }
}