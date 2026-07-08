class Solution {
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, mat, p);
            dfs(i, m - 1, mat, q);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, mat, p);
            dfs(n - 1, j, mat, q);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int[][] mat, boolean[][] visited) {
        visited[r][c] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length &&
                !visited[nr][nc] && mat[nr][nc] >= mat[r][c]) {
                dfs(nr, nc, mat, visited);
            }
        }
    }
}