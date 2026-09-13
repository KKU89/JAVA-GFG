class Solution {
public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
int[] a = farthest(0, adj);
int[] b = farthest(a[0], adj);
return (b[1] + 1) / 2;
}

private int[] farthest(int start, ArrayList<ArrayList<Integer>> adj) {
int n = adj.size();
int[] dist = new int[n];
Arrays.fill(dist, -1);
Queue<Integer> q = new ArrayDeque<>();
dist[start] = 0;
q.add(start);
int far = start;

while (!q.isEmpty()) {
int u = q.poll();
if (dist[u] > dist[far]) far = u;

for (int v1 : adj.get(u)) {
int v = v1 - 1;
if (dist[v] == -1) {
dist[v] = dist[u] + 1;
q.add(v);
}
}
}

return new int[]{far, dist[far]};
}
}

