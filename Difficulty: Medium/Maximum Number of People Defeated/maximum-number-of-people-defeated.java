class Solution {
    int maxPeopleDefeated(int p) {
        long sum = 0;
        int count = 0;

        for (int i = 1; ; i++) {
            sum += (long) i * i;

            if (sum > p) {
                break;
            }

            count++;
        }

        return count;
    }
}