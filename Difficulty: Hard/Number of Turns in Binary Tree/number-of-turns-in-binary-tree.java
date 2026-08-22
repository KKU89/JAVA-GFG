import java.util.*;

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        if (root == null) return -1;

        Map<Node, Node> parent = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        parent.put(root, null);
        queue.offer(root);

        Node pNode = null, qNode = null;

        while (!queue.isEmpty() && (pNode == null || qNode == null)) {
            Node node = queue.poll();

            if (node.data == p) pNode = node;
            if (node.data == q) qNode = node;

            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        if (pNode == null || qNode == null) return -1;

        List<Node> pathP = new ArrayList<>();
        Node cur = pNode;
        while (cur != null) {
            pathP.add(cur);
            cur = parent.get(cur);
        }
        Collections.reverse(pathP);

        List<Node> pathQ = new ArrayList<>();
        cur = qNode;
        while (cur != null) {
            pathQ.add(cur);
            cur = parent.get(cur);
        }
        Collections.reverse(pathQ);

        int lcaIdx = -1;
        int minLen = Math.min(pathP.size(), pathQ.size());
        for (int i = 0; i < minLen; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                lcaIdx = i;
            } else {
                break;
            }
        }

        if (lcaIdx == -1) return -1;

        List<Character> labels = new ArrayList<>();

        for (int i = pathP.size() - 1; i > lcaIdx; i--) {
            Node child = pathP.get(i);
            Node par = pathP.get(i - 1);
            labels.add(par.left == child ? 'L' : 'R');
        }

        for (int i = lcaIdx; i < pathQ.size() - 1; i++) {
            Node par = pathQ.get(i);
            Node child = pathQ.get(i + 1);
            labels.add(par.left == child ? 'L' : 'R');
        }

        int turns = 0;
        for (int i = 1; i < labels.size(); i++) {
            if (labels.get(i) != labels.get(i - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }
}