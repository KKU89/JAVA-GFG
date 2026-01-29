class Solution {
    static int isFactorial(int N) {

        int fact = 1;

        for (int i = 1; fact <= N; i++) {
            fact = fact * i;

            if (fact == N) {
                return 1;
            }
        }

        return 0;
    }
}
