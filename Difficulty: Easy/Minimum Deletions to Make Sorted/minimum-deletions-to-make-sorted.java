class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int len = 0;
        
        for (int x : arr) {
            int idx = lowerBound(dp, 0, len, x);
            dp[idx] = x;
            if (idx == len) {
                len++;
            }
        }
        
        return n - len;
    }
    
    private int lowerBound(int[] dp, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (dp[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}