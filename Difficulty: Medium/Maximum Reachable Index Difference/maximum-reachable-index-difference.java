class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] best = new int[26];
        java.util.Arrays.fill(best, -1);
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            int end;
            if (c == 25) {
                end = i;
            } else {
                end = best[c + 1];
                if (end == -1) {
                    end = i;
                }
            }
            best[c] = Math.max(best[c], end);
            if (c == 0) {
                ans = Math.max(ans, end - i);
            }
        }
        return ans;
    }
}