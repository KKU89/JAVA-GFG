class Solution {
    int maxSubstring(String s) {
        int maxFar = Integer.MIN_VALUE;
        int currMax = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int val = (s.charAt(i) == '0') ? 1 : -1;
            
            currMax += val;
            
            if (currMax > maxFar) {
                maxFar = currMax;
            }
            
            if (currMax < 0) {
                currMax = 0;
            }
        }
        
        return maxFar;
    }
}