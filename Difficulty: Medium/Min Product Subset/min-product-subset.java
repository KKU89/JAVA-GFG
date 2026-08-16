class Solution {
    public int minProd(int[] arr) {
        long prod = 1;
        int negCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        boolean hasZero = false;
        int minPos = Integer.MAX_VALUE;

        for (int x : arr) {
            if (x < 0) {
                negCount++;
                prod *= x;
                maxNeg = Math.max(maxNeg, x);
            } else if (x > 0) {
                prod *= x;
                minPos = Math.min(minPos, x);
            } else {
                hasZero = true;
            }
        }

        long ans;

        if (negCount > 0) {
            if (negCount % 2 == 1) {
                ans = prod;
            } else {
                ans = prod / maxNeg;
            }
        } else {
            ans = hasZero ? 0 : minPos;
        }

        return (int) ans;
    }
}