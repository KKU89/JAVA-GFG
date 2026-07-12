import java.util.*;

class Solution {
    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int tickets : arr) {
            pq.add(tickets);
        }
        
        long totalAmount = 0;
        long MOD = 1000000007;
        
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            
            int currentMax = pq.poll();
            
            totalAmount = (totalAmount + currentMax) % MOD;
            
            int remaining = currentMax - 1;
            
            if (remaining > 0) {
                pq.add(remaining);
            }
        }
        
        return (int) totalAmount;
    }
}''