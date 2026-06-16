class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        int xorSum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = queries.length - 1; i >= 0; i--) {
            if (queries[i][0] == 1) {
                xorSum ^= queries[i][1];
            } else {
                result.add(queries[i][1] ^ xorSum);
            }
        }
        
        result.add(0 ^ xorSum);
        Collections.sort(result);
        return result;
    }
}