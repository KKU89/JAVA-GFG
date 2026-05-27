class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int lastUncovered = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (i - x > lastUncovered) {
                    return false;
                }
                lastUncovered = i + x + 1;
            }
        }

        return lastUncovered >= n;
    }
}