class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }

        long maxNeg = Long.MIN_VALUE;
        int countNeg = 0;
        int countZero = 0;
        long prod = 1;
        long MOD = 1000000007;
        boolean hasPos = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }

            if (arr[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, arr[i]);
            } else {
                hasPos = true;
            }

            prod = (prod * Math.abs(arr[i])) % MOD;
        }

        if (countZero == n) {
            return 0;
        }

        if (countNeg % 2 != 0) {
            if (countNeg == 1 && countZero > 0 && !hasPos) {
                return 0;
            }
            
            long invMaxNeg = power(Math.abs(maxNeg), MOD - 2, MOD);
            prod = (prod * invMaxNeg) % MOD;
        }

        return (int) prod;
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