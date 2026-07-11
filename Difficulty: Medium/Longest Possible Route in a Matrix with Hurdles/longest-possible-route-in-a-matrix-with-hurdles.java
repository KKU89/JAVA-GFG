class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) return -1;
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        return findPath(mat, xs, ys, xd, yd, visited, 0);
    }

    private int findPath(int[][] mat, int i, int j, int xd, int yd, boolean[][] visited, int dist) {
        if (i == xd && j == yd) return dist;
        
        visited[i][j] = true;
        int maxDist = -1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            
            if (ni >= 0 && ni < mat.length && nj >= 0 && nj < mat[0].length && mat[ni][nj] == 1 && !visited[ni][nj]) {
                int res = findPath(mat, ni, nj, xd, yd, visited, dist + 1);
                if (res != -1) maxDist = Math.max(maxDist, res);
            }
        }
        
        visited[i][j] = false;
        return maxDist;
    }
}