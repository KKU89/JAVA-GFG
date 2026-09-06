class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;
        int n = arr.length;
        for (int i = 0; i < 32; i++) {
            long count = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            long pairs = (count * (count - 1)) / 2;
            totalSum += pairs * (1L << i);
        }
        return totalSum;
    }
}