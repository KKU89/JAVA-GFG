class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = arr[i];
        }

        arr[0] = prev[0] ^ prev[1];
        
        for (int i = 1; i < n - 1; i++) {
            arr[i] = prev[i - 1] ^ prev[i + 1];
        }

        arr[n - 1] = prev[n - 2] ^ prev[n - 1];
    }
}