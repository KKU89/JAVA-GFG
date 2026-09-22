class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        for (String w : d) {
            if (isSubsequence(w, s)) return w;
        }
        return "";
    }

    private boolean isSubsequence(String w, String s) {
        int i = 0, n = w.length(), m = s.length();
        if (n > m) return false;
        for (int j = 0; j < m && i < n; j++) {
            if (w.charAt(i) == s.charAt(j)) i++;
        }
        return i == n;
    }
}