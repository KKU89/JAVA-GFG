import java.util.*;

class Solution {
    public int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        List<Integer> cycleLengths = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int curr = i;
                int len = 0;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr] - 1;
                    len++;
                }
                cycleLengths.add(len);
            }
        }

        long ans = 1;
        long mod = 1_000_000_007;

        for (int len : cycleLengths) {
            ans = (ans * len) / gcd(ans, len);
            ans %= mod;
        }

        return (int) (ans % mod);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}