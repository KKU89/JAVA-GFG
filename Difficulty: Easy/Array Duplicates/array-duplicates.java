class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) {
                res.add(idx + 1);
            } else {
                arr[idx] = -arr[idx];
            }
        }
        return res;
    }
}
