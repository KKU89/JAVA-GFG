class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        int maxR = 0, maxH = 0;

        for (int i = 0; i < n; i++) {
            maxR = Math.max(maxR, r[i]);
            maxH = Math.max(maxH, h[i]);
        }

        boolean[][] has = new boolean[maxR + 1][maxH + 1];
        for (int i = 0; i < n; i++) {
            has[r[i]][h[i]] = true;
        }

        int[] best = new int[maxH + 1];
        int[] row = new int[maxH + 1];
        int ans = 0;

        for (int rr = 1; rr <= maxR; rr++) {
            for (int hh = 1; hh <= maxH; hh++) {
                if (has[rr][hh]) {
                    int dp = hh + best[hh - 1];
                    row[hh] = dp;
                    ans = Math.max(ans, dp);
                }
            }

            for (int hh = 1; hh <= maxH; hh++) {
                if (row[hh] > best[hh]) {
                    best[hh] = row[hh];
                }
                row[hh] = 0;
            }

            int runningMax = 0;
            for (int hh = 1; hh <= maxH; hh++) {
                runningMax = Math.max(runningMax, best[hh]);
                best[hh] = runningMax;
            }
        }

        return ans;
    }
}