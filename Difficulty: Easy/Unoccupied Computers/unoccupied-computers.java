class Solution {
    public int solve(int n, String s) {
        int[] state = new int[26];
        for (int i = 0; i < 26; i++) {
            state[i] = -1;
        }

        int occupied = 0;
        int rejected = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            if (state[idx] == -1) {
                if (occupied < n) {
                    occupied++;
                    state[idx] = 1;
                } else {
                    state[idx] = 0;
                    rejected++;
                }
            } else if (state[idx] == 1) {
                occupied--;
            }
        }

        return rejected;
    }
}