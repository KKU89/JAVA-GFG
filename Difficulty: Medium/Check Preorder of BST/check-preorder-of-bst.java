class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            while (!s.isEmpty() && s.peek() < arr.get(i)) {
                root = s.peek();
                s.pop();
            }
            if (arr.get(i) < root) {
                return false;
            }
            s.push(arr.get(i));
        }
        return true;
    }
}