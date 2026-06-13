class Solution {
    public int computeValue(int n) {
        long mod = 1000000007;
        long num = 1;
        long den = 1;

        for (int i = 1; i <= n; i++) {
            num = (num * (n + i)) % mod;
            den = (den * i) % mod;
        }

        return (int) ((num * power(den, mod - 2, mod)) % mod);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
