class Solution {
    public int prefixStrings(int n) {
        final int MOD = 1_000_000_007;
        int max = 2 * n;
        long[] fact = new long[max + 1];
        fact[0] = 1;
        for (int i = 1; i <= max; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        long[] invFact = new long[max + 1];
        invFact[max] = modPow(fact[max], MOD - 2, MOD);
        for (int i = max; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
        long comb = fact[2 * n] * invFact[n] % MOD * invFact[n] % MOD;
        long invNPlus1 = modPow(n + 1, MOD - 2, MOD);
        return (int) (comb * invNPlus1 % MOD);
    }
    private long modPow(long a, long e, long mod) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            e >>= 1;
        }
        return res;
    }
}