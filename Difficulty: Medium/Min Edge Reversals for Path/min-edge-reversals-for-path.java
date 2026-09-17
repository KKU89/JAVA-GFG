import java.util.*;

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        if (src == dst) return 0;

        int m = edges.length;
        int[] head = new int[n + 1];
        Arrays.fill(head, -1);

        int[] to = new int[2 * m];
        int[] wt = new int[2 * m];
        int[] next = new int[2 * m];

        int idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];

            to[idx] = v;
            wt[idx] = 0;
            next[idx] = head[u];
            head[u] = idx++;

            to[idx] = u;
            wt[idx] = 1;
            next[idx] = head[v];
            head[v] = idx++;
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] used = new boolean[n + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0;
        dq.addFirst(src);

        while (!dq.isEmpty()) {
            int u = dq.removeFirst();

            if (used[u]) continue;
            used[u] = true;

            for (int i = head[u]; i != -1; i = next[i]) {
                int v = to[i];
                int nd = dist[u] + wt[i];

                if (nd < dist[v]) {
                    dist[v] = nd;

                    if (wt[i] == 0) {
                        dq.addFirst(v);
                    } else {
                        dq.addLast(v);
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}