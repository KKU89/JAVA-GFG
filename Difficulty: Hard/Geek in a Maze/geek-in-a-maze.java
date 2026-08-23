import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length, m = mat[0].length;
        if (mat[r][c] == '#') return 0;

        int[] dist = new int[n * m];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<int[]> q = new ArrayDeque<>();
        int start = r * m + c;
        dist[start] = 0;
        q.addFirst(new int[]{r, c, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[] cost = {1, 0, 0, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], curDist = cur[2];
            int idx = x * m + y;
            if (curDist != dist[idx]) continue;

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (mat[nx][ny] == '#') continue;

                int nd = curDist + cost[k];
                if (nd > u) continue;
                if (nd + nx - r > d) continue;

                int nidx = nx * m + ny;
                if (nd < dist[nidx]) {
                    dist[nidx] = nd;
                    if (cost[k] == 0) {
                        q.addFirst(new int[]{nx, ny, nd});
                    } else {
                        q.addLast(new int[]{nx, ny, nd});
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '#') continue;
                int idx = i * m + j;
                int dd = dist[idx];
                if (dd <= u && dd + i - r <= d) ans++;
            }
        }
        return ans;
    }
}