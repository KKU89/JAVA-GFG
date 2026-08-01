class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        int[] diff = new int[n + 1];
        int m = a.length;
        
        for (int i = 0; i < m; i++) {
            diff[a[i]] += k[i];
            if (b[i] + 1 < n) {
                diff[b[i] + 1] -= k[i];
            }
        }
        
        int maxVal = 0;
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            maxVal = Math.max(maxVal, current);
        }
        
        return maxVal;
    }
}