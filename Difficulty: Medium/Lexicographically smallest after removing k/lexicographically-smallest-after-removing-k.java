import java.util.Stack;

class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        if ((n & (n - 1)) == 0) {
            k /= 2;
        } else {
            k *= 2;
        }
        
        if (k >= n) {
            return "-1";
        }
        if (k <= 0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        int removalsLeft = k;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && removalsLeft > 0) {
                sb.deleteCharAt(sb.length() - 1);
                removalsLeft--;
            }
            sb.append(ch);
        }
        
        while (removalsLeft > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            removalsLeft--;
        }
        
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}