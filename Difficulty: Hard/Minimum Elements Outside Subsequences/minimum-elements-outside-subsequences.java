class Solution {
    public int minCount(int[] arr) {
        int MAXV = 100;
        int NONE_INC = 0;
        int NONE_DEC = MAXV + 1;
        int S = MAXV + 2;
        int[][] dp = new int[S][S];
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                dp[i][j] = -1;
            }
        }
        dp[NONE_INC][NONE_DEC] = 0;
        for (int v : arr) {
            int[][] ndp = new int[S][S];
            for (int i = 0; i < S; i++) {
                for (int j = 0; j < S; j++) {
                    ndp[i][j] = dp[i][j];
                }
            }
            for (int inc = 0; inc <= MAXV; inc++) {
                for (int dec = 1; dec <= MAXV + 1; dec++) {
                    int cur = dp[inc][dec];
                    if (cur < 0) continue;
                    if (v > inc) {
                        int cand = cur + 1;
                        if (cand > ndp[v][dec]) ndp[v][dec] = cand;
                    }
                    if (v < dec) {
                        int cand = cur + 1;
                        if (cand > ndp[inc][v]) ndp[inc][v] = cand;
                    }
                }
            }
            dp = ndp;
        }
        int best = 0;
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (dp[i][j] > best) best = dp[i][j];
            }
        }
        return arr.length - best;
    }
}