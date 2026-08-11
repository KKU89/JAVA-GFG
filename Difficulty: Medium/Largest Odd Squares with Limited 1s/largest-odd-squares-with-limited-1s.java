class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];
            
            int maxRadius = Math.min(Math.min(r, n - 1 - r), Math.min(c, m - 1 - c));
            int best = -1;
            
            int low = 0, high = maxRadius;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int side = 2 * mid + 1;
                
                int x1 = r - mid;
                int y1 = c - mid;
                int x2 = r + mid;
                int y2 = c + mid;
                
                int ones = pref[x2 + 1][y2 + 1] - pref[x1][y2 + 1] - pref[x2 + 1][y1] + pref[x1][y1];
                
                if (ones <= k) {
                    best = side;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            ans.add(best);
        }
        
        return ans;
    }
}