import java.util.*;

class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] safe = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) continue;
                boolean ok = true;
                for (int d = 0; d < 4; d++) {
                    int ni = i + dr[d], nj = j + dc[d];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 0) {
                        ok = false;
                        break;
                    }
                }
                safe[i][j] = ok;
            }
        }

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (safe[i][0]) {
                dist[i][0] = 0;
                q.add(new int[]{i, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (c == m - 1) return dist[r][c] + 1;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && safe[nr][nc] && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}