class Solution {
    public int maxSumWithK(int arr[], int k) {
        int n = arr.length;
        long[] maxEnding = new long[n];
        maxEnding[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding[i] = Math.max(arr[i], maxEnding[i - 1] + arr[i]);
        }
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        long ans = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            ans = Math.max(ans, windowSum);
            ans = Math.max(ans, windowSum + maxEnding[i - k]);
        }
        return (int) ans;
    }
}