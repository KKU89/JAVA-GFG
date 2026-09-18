class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return min;
    }

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            min = Math.min(min, root.data - prev);
        }
        prev = root.data;
        inorder(root.right);
    }
}