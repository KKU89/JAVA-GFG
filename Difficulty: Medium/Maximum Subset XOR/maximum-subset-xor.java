class Solution {
    public int maxSubsetXOR(int[] arr) {
        int index = 0;
        int n = arr.length;
        for (int i = 31; i >= 0; i--) {
            int maxInd = index;
            int maxEle = Integer.MIN_VALUE;
            for (int j = index; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0 && arr[j] > maxEle) {
                    maxEle = arr[j];
                    maxInd = j;
                }
            }
            if (maxEle == Integer.MIN_VALUE) {
                continue;
            }
            int temp = arr[index];
            arr[index] = arr[maxInd];
            arr[maxInd] = temp;
            for (int j = 0; j < n; j++) {
                if (j != index && (arr[j] & (1 << i)) != 0) {
                    arr[j] ^= arr[index];
                }
            }
            index++;
        }
        int maxXor = 0;
        for (int i = 0; i < n; i++) {
            maxXor ^= arr[i];
        }
        return maxXor;
    }
}