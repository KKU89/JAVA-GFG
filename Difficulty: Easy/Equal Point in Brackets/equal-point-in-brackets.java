class Solution {
    public int findIndex(String s) {
        int closeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                closeCount++;
            }
        }
        return closeCount;
    }
}