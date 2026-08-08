class Solution {
    int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    void union(int parent[], int rank[], int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1)
            return -1;
            
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int extraEdges = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (find(parent, u) == find(parent, v)) {
                extraEdges++;
            } else {
                union(parent, rank, u, v);
            }
        }
        
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }
        
        int requiredEdges = components - 1;
        if (extraEdges >= requiredEdges) {
            return requiredEdges;
        }
        return -1;
    }
}