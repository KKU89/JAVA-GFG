import java.util.Arrays;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;
        int[] jump = new int[target + 1];
        Arrays.fill(jump, -1);

        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        int[] dist = new int[target + 1];
        Arrays.fill(dist, -1);

        int[] queue = new int[target + 1];
        int front = 0, rear = 0;

        queue[rear++] = 1;
        dist[1] = 0;

        while (front < rear) {
            int curr = queue[front++];

            if (curr == target) {
                return dist[curr];
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = curr + dice;

                if (next > target) break;

                if (jump[next] != -1) {
                    next = jump[next];
                }

                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue[rear++] = next;
                }
            }
        }

        return -1;
    }
}