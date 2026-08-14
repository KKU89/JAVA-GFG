import java.util.ArrayList;

class Solution {
    public boolean isPossible(int[] arr, long s, long x) {
        if (x == 0) return true;
        ArrayList<Long> nums = new ArrayList<>();
        if (s > x) return false;
        nums.add(s);
        long total = s;
        for (int a : arr) {
            long written = total + a;
            if (written > x) break;
            nums.add(written);
            total += written;
            if (total > x) break;
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (x >= nums.get(i)) {
                x -= nums.get(i);
            }
        }
        return x == 0;
    }
}