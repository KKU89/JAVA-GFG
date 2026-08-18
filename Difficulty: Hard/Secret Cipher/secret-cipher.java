class Solution {
    public String compress(String s) {
        int n = s.length();
        if (n == 0) return "";

        // Z-array: z[i] = LCP of s and s[i..]
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        // rem[i] = minimum encrypted chars needed to decode s[i..n-1]
        int[] rem = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            // Normal character
            rem[i] = 1 + rem[i + 1];

            // '*' can be used if prefix of length i repeats immediately
            if (i > 0 && 2 * i <= n && z[i] >= i) {
                rem[i] = Math.min(rem[i], 1 + rem[2 * i]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int pos = 0;

        while (pos < n) {
            // Prefer '*' over normal character on tie for lexicographically smallest
            if (pos > 0 && 2 * pos <= n && z[pos] >= pos &&
                1 + rem[2 * pos] == rem[pos]) {
                ans.append('*');
                pos = 2 * pos;
            } else {
                ans.append(s.charAt(pos));
                pos++;
            }
        }

        return ans.toString();
    }
}