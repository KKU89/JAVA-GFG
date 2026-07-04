import java.util.*;

class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        int[] bit = new int[2 * n + 2];
        int offset = n + 1;
        
        update(bit, 0 + offset, 1);
        
        int count = 0;
        int runningSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                runningSum++;
            } else {
                runningSum--;
            }
            
            count += query(bit, runningSum + offset - 1);
            update(bit, runningSum + offset, 1);
        }
        
        return count;
    }
    
    private void update(int[] bit, int idx, int val) {
        for (; idx < bit.length; idx += idx & -idx) {
            bit[idx] += val;
        }
    }
    
    private int query(int[] bit, int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }

    
}