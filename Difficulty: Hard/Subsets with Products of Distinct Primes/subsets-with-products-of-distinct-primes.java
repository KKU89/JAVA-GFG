class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int PRIME_COUNT = 10;
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    private static final int[] primeMask = new int[31];
    private static final boolean[] usable = new boolean[31];

    static {
        for (int v = 1; v <= 30; v++) {
            int x = v;
            int mask = 0;
            boolean squareFree = true;

            for (int i = 0; i < PRIME_COUNT; i++) {
                int p = PRIMES[i];
                if (x % p == 0) {
                    int cnt = 0;
                    while (x % p == 0) {
                        x /= p;
                        cnt++;
                    }
                    if (cnt > 1) squareFree = false;
                    mask |= (1 << i);
                }
            }

            if (x > 1) squareFree = false; // not needed for constraints, but safe

            primeMask[v] = mask;
            usable[v] = squareFree && mask != 0; // 1 is not counted
        }
    }

    public int countSubsets(int[] arr) {
        int[] freq = new int[1 << PRIME_COUNT];
        int ones = 0;

        for (int val : arr) {
            if (val == 1) {
                ones++;
            } else if (usable[val]) {
                freq[primeMask[val]]++;
            }
        }

        long[] dp = new long[1 << PRIME_COUNT];
        dp[0] = 1;

        for (int mask = 1; mask < dp.length; mask++) {
            int f = freq[mask];
            if (f == 0) continue;

            for (int state = 0; state < dp.length; state++) {
                if ((state & mask) == 0) {
                    dp[state | mask] = (dp[state | mask] + dp[state] * f) % MOD;
                }
            }
        }

        long validNonOneSubsets = 0;
        for (int mask = 1; mask < dp.length; mask++) {
            validNonOneSubsets += dp[mask];
            if (validNonOneSubsets >= MOD) {
                validNonOneSubsets -= MOD;
            }
        }

        long ans = validNonOneSubsets * modPow(2, ones) % MOD;
        return (int) ans;
    }

    private long modPow(long a, int e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            e >>= 1;
        }
        return res;
    }
}