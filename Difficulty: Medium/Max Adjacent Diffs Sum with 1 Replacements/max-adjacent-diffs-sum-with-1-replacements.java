class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;
        long dp0 = 0, dp1 = 0;
        for (int i = 1; i < n; i++) {
            long prev0 = dp0, prev1 = dp1;
            long aPrev = arr[i - 1], aCurr = arr[i];
            long ndp0 = Math.max(prev0 + Math.abs(aPrev - aCurr), prev1 + Math.abs(1 - aCurr));
            long ndp1 = Math.max(prev0 + Math.abs(aPrev - 1), prev1);
            dp0 = ndp0;
            dp1 = ndp1;
        }
        return (int) Math.max(dp0, dp1);
    }
}