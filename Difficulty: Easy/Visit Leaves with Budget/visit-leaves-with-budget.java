class Solution {
    public int getCount(Node root, int k) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left == null && current.right == null) {
                    if (k >= level) {
                        k -= level;
                        count++;
                    } else {
                        return count;
                    }
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
        }

        return count;
    }
}