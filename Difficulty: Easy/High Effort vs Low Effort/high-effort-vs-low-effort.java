class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        if (n == 0) return 0;
        
        int[] high = new int[n];
        int[] low = new int[n];
        int[] none = new int[n];
        
        high[0] = h[0];
        low[0] = l[0];
        none[0] = 0;
        
        for (int i = 1; i < n; i++) {
            high[i] = h[i] + none[i - 1];
            low[i] = l[i] + Math.max(Math.max(high[i - 1], low[i - 1]), none[i - 1]);
            none[i] = Math.max(Math.max(high[i - 1], low[i - 1]), none[i - 1]);
        }
        
        return Math.max(Math.max(high[n - 1], low[n - 1]), none[n - 1]);
    }
}