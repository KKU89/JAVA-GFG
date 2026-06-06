class Solution {
    public long numOfWays(int n, int m) {
        long totalSquares = (long) n * m;
        long totalWays = totalSquares * (totalSquares - 1);
        long attackingPairs = 0;

        if (n >= 1 && m >= 2) {
            attackingPairs += 2L * n * (m - 1);
        }
        if (n >= 2 && m >= 1) {
            attackingPairs += 2L * (n - 1) * m;
        }

        long attackingWays = 0;
        if (n >= 2 && m >= 3) {
            attackingWays += 4L * (n - 1) * (m - 2);
        }
        if (n >= 3 && m >= 2) {
            attackingWays += 4L * (n - 2) * (m - 1);
        }

        return totalWays - attackingWays;
    }
}