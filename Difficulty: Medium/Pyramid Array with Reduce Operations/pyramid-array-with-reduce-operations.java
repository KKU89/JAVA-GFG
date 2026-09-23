class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (i == 0) {
                left[i] = Math.min(arr[i], 1);
            } else {
                left[i] = Math.min(arr[i], left[i - 1] + 1);
            }
        }

        int maxX = 0;
        int right = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right = Math.min(arr[i], 1);
            } else {
                right = Math.min(arr[i], right + 1);
            }
            maxX = Math.max(maxX, Math.min(left[i], right));
        }

        long cost = total - (long) maxX * maxX;
        return (int) cost;
    }
}