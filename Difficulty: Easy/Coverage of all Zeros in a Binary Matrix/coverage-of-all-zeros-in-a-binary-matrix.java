class Solution {
    public int findCoverage(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int totalCoverage = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    for (int up = i - 1; up >= 0; up--) {
                        if (mat[up][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    for (int down = i + 1; down < rows; down++) {
                        if (mat[down][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    for (int left = j - 1; left >= 0; left--) {
                        if (mat[i][left] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                    for (int right = j + 1; right < cols; right++) {
                        if (mat[i][right] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                }
            }
        }
        return totalCoverage;
    }
}