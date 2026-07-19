import java.util.ArrayList;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] lastInc = new int[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && arr[i] < arr[i + 1]) {
                last = i;
            }
            lastInc[i] = last;
        }

        int[] firstDec = new int[n];
        int first = n;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && arr[i] > arr[i + 1]) {
                first = i;
            }
            firstDec[i] = first;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            if (l == r) {
                ans.add(true);
                continue;
            }

            int lastIncrease = lastInc[r - 1];
            int firstDecrease = firstDec[l];

            ans.add(lastIncrease < firstDecrease);
        }

        return ans;
    }
}