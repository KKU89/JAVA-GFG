class Solution {
    private int sumDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int findMax(int n) {
        int maxNum = n;
        int maxSum = sumDigits(n);

        long base = 1;
        while (base <= n) {
            int candidate = (int) ((n / base) * base - 1);
            if (candidate > 0) {
                int currentSum = sumDigits(candidate);
                if (currentSum > maxSum || (currentSum == maxSum && candidate > maxNum)) {
                    maxSum = currentSum;
                    maxNum = candidate;
                }
            }
            base *= 10;
        }

        return maxNum;
    }
}