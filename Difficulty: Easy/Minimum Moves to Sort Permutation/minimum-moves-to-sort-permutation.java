class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }
        int maxRun = 1, cur = 1;
        for (int i = 1; i < n; i++) {
            if (pos[i] < pos[i + 1]) {
                cur++;
            } else {
                if (cur > maxRun) maxRun = cur;
                cur = 1;
            }
        }
        if (cur > maxRun) maxRun = cur;
        return n - maxRun;
    }
}