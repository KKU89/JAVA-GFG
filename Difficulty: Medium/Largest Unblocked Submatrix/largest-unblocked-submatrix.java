class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        int[] rows = new int[n + 2];
        int[] cols = new int[m + 2];
        for (int[] cell : arr) {
            rows[cell[0]] = 1;
            cols[cell[1]] = 1;
        }
        int maxR = 0, currR = 0;
        for (int i = 1; i <= n; i++) {
            if (rows[i] == 0) {
                currR++;
                maxR = Math.max(maxR, currR);
            } else {
                currR = 0;
            }
        }
        int maxC = 0, currC = 0;
        for (int i = 1; i <= m; i++) {
            if (cols[i] == 0) {
                currC++;
                maxC = Math.max(maxC, currC);
            } else {
                currC = 0;
            }
        }
        return maxR * maxC;
    }
}
