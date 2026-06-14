class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int i = 0, j = 0;
        int dir = 0;
        int prevI = 0, prevJ = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (i >= 0 && i < n && j >= 0 && j < m) {
            prevI = i;
            prevJ = j;

            if (mat[i][j] == 1) {
                mat[i][j] = 0;
                dir = (dir + 1) % 4;
            }

            i += directions[dir][0];
            j += directions[dir][1];
        }

        List<Integer> result = new ArrayList<>();
        result.add(prevI);
        result.add(prevJ);
        return result;
    }
}