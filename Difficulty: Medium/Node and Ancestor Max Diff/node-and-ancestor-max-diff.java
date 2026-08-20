class Solution {
    int maxDiff(Node root) {
        if (root == null) return 0;

        int[] ans = new int[]{Integer.MIN_VALUE};

        if (root.left != null) dfs(root.left, root.data, ans);
        if (root.right != null) dfs(root.right, root.data, ans);

        return ans[0];
    }

    private void dfs(Node node, int maxAncestor, int[] ans) {
        ans[0] = Math.max(ans[0], maxAncestor - node.data);

        int newMax = Math.max(maxAncestor, node.data);

        if (node.left != null) dfs(node.left, newMax, ans);
        if (node.right != null) dfs(node.right, newMax, ans);
    }
}