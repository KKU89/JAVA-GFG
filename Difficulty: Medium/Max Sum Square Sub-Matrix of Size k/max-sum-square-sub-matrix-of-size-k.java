class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int[][] stripSum = new int[n][n];

        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += mat[i][j];
            }
            stripSum[0][j] = sum;
            for (int i = 1; i <= n - k; i++) {
                sum += mat[i + k - 1][j] - mat[i - 1][j];
                stripSum[i][j] = sum;
            }
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += stripSum[i][j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
            for (int j = 1; j <= n - k; j++) {
                sum += stripSum[i][j + k - 1] - stripSum[i][j - 1];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}