class Solution {
    public void MakeZeros(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: Create copy of matrix
        int[][] result = new int[n][m];

        // Copy original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        // Step 2: Process zeroes using original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    int sum = 0;

                    // up
                    if (i - 1 >= 0) sum += matrix[i - 1][j];
                    // down
                    if (i + 1 < n) sum += matrix[i + 1][j];
                    // left
                    if (j - 1 >= 0) sum += matrix[i][j - 1];
                    // right
                    if (j + 1 < m) sum += matrix[i][j + 1];

                    // update zero position
                    result[i][j] = sum;

                    // make neighbors zero
                    if (i - 1 >= 0) result[i - 1][j] = 0;
                    if (i + 1 < n) result[i + 1][j] = 0;
                    if (j - 1 >= 0) result[i][j - 1] = 0;
                    if (j + 1 < m) result[i][j + 1] = 0;
                }
            }
        }

        // Step 3: Copy result back to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
