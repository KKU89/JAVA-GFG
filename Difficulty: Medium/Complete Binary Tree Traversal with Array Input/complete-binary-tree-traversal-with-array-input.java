class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        int start = 0;
        int count = 1;
        
        while (start < n) {
            int end = Math.min(n, start + count);
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = start; i < end; i++) {
                level.add(arr[i]);
            }
            Collections.sort(level);
            res.add(level);
            start = end;
            count *= 2;
        }
        
        return res;
    }
}