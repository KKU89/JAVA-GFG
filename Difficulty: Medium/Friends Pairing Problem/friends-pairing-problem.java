class Solution {
    public int countFriendsPairings(int n) {
        if (n <= 2) {
            return n;
        }
        
        long a = 1;
        long b = 2;
        long mod = 1000000007;
        long c = 0;
        
        for (int i = 3; i <= n; i++) {
            c = (b + (i - 1) * a) % mod;
            a = b;
            b = c;
        }
        
        return (int) b;
    }
}