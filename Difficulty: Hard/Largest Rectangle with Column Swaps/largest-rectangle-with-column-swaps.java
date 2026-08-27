import java.util.Arrays;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] heights = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[j] = (mat[i][j] == 1) ? heights[j] + 1 : 0;
            }

            int[] sorted = heights.clone();
            Arrays.sort(sorted);

            for (int j = m - 1; j >= 0; j--) {
                int area = sorted[j] * (m - j);
                if (area > ans) ans = area;
            }
        }
        return ans;
    }
}