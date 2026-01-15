class Solution {
    public int nCr(int n, int r) {
        if (r > n) {
            return 0;
        }
        r = Math.min(r, n - r);

        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - r + i) / i;
        }

        return (int) result;
    }
}
