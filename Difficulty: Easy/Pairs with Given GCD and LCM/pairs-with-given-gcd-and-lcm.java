class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) return 0;
        int n = y / x;
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0 && gcd(i, n / i) == 1) {
                count += (i == n / i) ? 1 : 2;
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}