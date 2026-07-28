import java.util.*;

class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Dial's algorithm / bucket queue:
        // Since weights are only 1 or 2, max distance <= 2 * (V - 1)
        int maxDist = 2 * V + 5;
        List<Integer>[] buckets = new List[maxDist];
        for (int i = 0; i < maxDist; i++) {
            buckets[i] = new ArrayList<>();
        }

        buckets[0].add(src);

        for (int d = 0; d < maxDist; d++) {
            for (int u : buckets[d]) {
                if (dist[u] != d) continue; // stale entry

                if (u == dest) return d;

                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    int nd = d + w;

                    if (nd < dist[v]) {
                        dist[v] = nd;
                        buckets[nd].add(v);
                    }
                }
            }
        }

        return -1;
    }
}