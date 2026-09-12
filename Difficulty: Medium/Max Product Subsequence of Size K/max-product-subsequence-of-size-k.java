import java.math.BigInteger;

class Solution {
    public int maxProduct(int[] arr, int k) {
        BigInteger[] max = new BigInteger[k + 1];
        BigInteger[] min = new BigInteger[k + 1];
        max[0] = BigInteger.ONE;
        min[0] = BigInteger.ONE;
        int count = 0;

        for (int x : arr) {
            BigInteger bx = BigInteger.valueOf(x);
            int upper = Math.min(count, k - 1);

            for (int c = upper; c >= 0; c--) {
                if (max[c] == null) continue;

                BigInteger p1 = max[c].multiply(bx);
                BigInteger p2 = min[c].multiply(bx);
                BigInteger mx = p1.max(p2);
                BigInteger mn = p1.min(p2);

                if (max[c + 1] == null || mx.compareTo(max[c + 1]) > 0) {
                    max[c + 1] = mx;
                }
                if (min[c + 1] == null || mn.compareTo(min[c + 1]) < 0) {
                    min[c + 1] = mn;
                }
            }
            count++;
        }

        return max[k].intValue();
    }
}