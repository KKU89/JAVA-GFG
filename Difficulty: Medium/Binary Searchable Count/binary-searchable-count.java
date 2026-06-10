import java.util.Arrays;

class Solution {
    public int binarySearchable(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

      
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int searchableCount = 0;

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int l = 0;
            int r = n - 1;
            boolean found = false;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (arr[mid] == target) {
                    found = true;
                    break;
                } else if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (found) {
                searchableCount++;
            }
        }

        return searchableCount;
    }
}