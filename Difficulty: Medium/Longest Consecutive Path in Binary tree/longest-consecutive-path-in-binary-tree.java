import java.util.*;

class Solution {
    private static class Frame {
        Node node;
        int state;          // 0: before left, 1: after left, 2: ready to compute
        int leftLen;
        int rightLen;

        Frame(Node node) {
            this.node = node;
            this.state = 0;
            this.leftLen = 0;
            this.rightLen = 0;
        }
    }

    public int longestConsecutive(Node root) {
        if (root == null) return -1;

        Deque<Frame> stack = new ArrayDeque<>();
        stack.push(new Frame(root));
        int maxLen = 0;

        while (!stack.isEmpty()) {
            Frame f = stack.peek();

            if (f.state == 0) {
                f.state = 1;
                if (f.node.left != null) {
                    stack.push(new Frame(f.node.left));
                }
            } else if (f.state == 1) {
                f.state = 2;
                if (f.node.right != null) {
                    stack.push(new Frame(f.node.right));
                }
            } else {
                Node node = f.node;
                int cur = 1;

                if (node.left != null && node.left.data == node.data + 1) {
                    cur = Math.max(cur, 1 + f.leftLen);
                    maxLen = Math.max(maxLen, 1 + f.leftLen);
                }

                if (node.right != null && node.right.data == node.data + 1) {
                    cur = Math.max(cur, 1 + f.rightLen);
                    maxLen = Math.max(maxLen, 1 + f.rightLen);
                }

                stack.pop();

                if (!stack.isEmpty()) {
                    Frame parent = stack.peek();
                    if (parent.node.left == node) {
                        parent.leftLen = cur;
                    } else if (parent.node.right == node) {
                        parent.rightLen = cur;
                    }
                }
            }
        }

        return maxLen >= 2 ? maxLen : -1;
    }
}