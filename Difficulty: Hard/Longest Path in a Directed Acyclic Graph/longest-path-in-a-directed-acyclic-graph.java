class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Pair(v, w));
        }

        int[] topo = topologicalSort(V, adj);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MIN_VALUE;
        }
        
        dist[src] = 0;

        for (int i = 0; i < V; i++) {
            int u = topo[i];
            if (dist[u] != Integer.MIN_VALUE) {
                for (Pair neighbor : adj.get(u)) {
                    int v = neighbor.v;
                    int weight = neighbor.weight;
                    if (dist[u] + weight > dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        return dist;
    }

    private int[] topologicalSort(int V, ArrayList<ArrayList<Pair>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (Pair neighbor : adj.get(i)) {
                indegree[neighbor.v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[idx++] = node;

            for (Pair neighbor : adj.get(node)) {
                indegree[neighbor.v]--;
                if (indegree[neighbor.v] == 0) {
                    q.add(neighbor.v);
                }
            }
        }
        return topo;
    }

    private static class Pair {
        int v, weight;
        Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}