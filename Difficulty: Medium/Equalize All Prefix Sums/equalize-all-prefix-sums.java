import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        
        long currentOperations = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result.add(0);
            } else {
                int median = arr[i / 2];
                currentOperations += (long) arr[i] - median;
                result.add((int) currentOperations);
            }
        }
        
        return result;
    }
}