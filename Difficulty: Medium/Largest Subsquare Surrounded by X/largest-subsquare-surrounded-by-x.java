class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'X') {
                    right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (mat[i][j] == 'X') {
                    down[i][j] = 1 + (i + 1 < n ? down[i + 1][j] : 0);
                }
            }
        }

        int total = n * n;
        int[] headR = new int[n + 1];
        int[] headD = new int[n + 1];
        java.util.Arrays.fill(headR, -1);
        java.util.Arrays.fill(headD, -1);

        int[] nextR = new int[total];
        int[] nextD = new int[total];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                int rv = right[i][j];
                int dv = down[i][j];

                if (rv > 0) {
                    nextR[id] = headR[rv];
                    headR[rv] = id;
                }
                if (dv > 0) {
                    nextD[id] = headD[dv];
                    headD[dv] = id;
                }
            }
        }

        int words = (n + 63) >> 6;
        long[][] H = new long[n][words];
        long[][] V = new long[n][words];

        for (int s = n; s >= 1; s--) {
            for (int id = headR[s]; id != -1; id = nextR[id]) {
                int i = id / n;
                int j = id % n;
                H[i][j >> 6] |= 1L << (j & 63);
            }

            for (int id = headD[s]; id != -1; id = nextD[id]) {
                int i = id / n;
                int j = id % n;
                V[i][j >> 6] |= 1L << (j & 63);
            }

            int shift = s - 1;
            int ws = shift >> 6;
            int bs = shift & 63;

            for (int r = 0; r + s <= n; r++) {
                int r2 = r + s - 1;
                long[] H1 = H[r];
                long[] H2 = H[r2];
                long[] V1 = V[r];

                for (int w = 0; w < words; w++) {
                    long shifted;
                    int idx = w + ws;

                    if (bs == 0) {
                        shifted = idx < words ? V1[idx] : 0L;
                    } else {
                        long lo = idx < words ? (V1[idx] >>> bs) : 0L;
                        long hi = idx + 1 < words ? (V1[idx + 1] << (64 - bs)) : 0L;
                        shifted = lo | hi;
                    }

                    if ((H1[w] & H2[w] & V1[w] & shifted) != 0L) {
                        return s;
                    }
                }
            }
        }

        return 0;
    }
}