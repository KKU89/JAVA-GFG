class Solution {
    public int countMinOperations(int[] arr) {
        int operations = 0;
        int maxDoubles = 0;
        
        for (int x : arr) {
            int doubles = 0;
            int temp = x;
            while (temp > 0) {
                if (temp % 2 == 1) {
                    temp--;
                    operations++;
                } else {
                    temp /= 2;
                    doubles++;
                }
            }
            maxDoubles = Math.max(maxDoubles, doubles);
        }
        
        return operations + maxDoubles;
    }
}