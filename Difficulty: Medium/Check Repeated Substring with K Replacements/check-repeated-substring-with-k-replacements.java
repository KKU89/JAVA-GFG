import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        if (n % k != 0) {
            return false;
        }

        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String sub = s.substring(i, i + k);
            counts.put(sub, counts.getOrDefault(sub, 0) + 1);
        }

        if (counts.size() == 1) {
            return true;
        }

        if (counts.size() == 2) {
            for (int count : counts.values()) {
                if (count == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
