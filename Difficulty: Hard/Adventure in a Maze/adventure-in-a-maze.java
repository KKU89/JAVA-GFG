class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        long MOD = 1_000_000_007;
        
        long[][] ways = new long[n][n];
        int[][] maxAdv = new int[n][n];
        
        ways[0][0] = 1;
        maxAdv[0][0] = grid[0][0];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ways[i][j] == 0) continue;
                
                int val = grid[i][j];
                
                if (val == 1 || val == 3) {
                    if (j + 1 < n) {
                        update(ways, maxAdv, i, j + 1, i, j, grid[i][j + 1], MOD);
                    }
                }
                
                if (val == 2 || val == 3) {
                    if (i + 1 < n) {
                        update(ways, maxAdv, i + 1, j, i, j, grid[i + 1][j], MOD);
                    }
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) ways[n - 1][n - 1]);
        result.add(maxAdv[n - 1][n - 1]);
        return result;
    }
    
    private void update(long[][] ways, int[][] maxAdv, int ni, int nj, int pi, int pj, int cellVal, long MOD) {
        long newWays = ways[pi][pj];
        int newAdv = maxAdv[pi][pj] + cellVal;
        
        if (ways[ni][nj] == 0) {
            ways[ni][nj] = newWays % MOD;
            maxAdv[ni][nj] = newAdv;
        } else {
            ways[ni][nj] = (ways[ni][nj] + newWays) % MOD;
            maxAdv[ni][nj] = Math.max(maxAdv[ni][nj], newAdv);
        }
    }
}