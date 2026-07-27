/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        // code here
        return build(pre, preMirror, 0, pre.length - 1, 0, preMirror.length - 1);
    }
    
    private Node build(int[] pre, int[] preMirror, int preStart, int preEnd, int mirrorStart, int mirrorEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        Node root = new Node(pre[preStart]);
        
        if (preStart == preEnd) {
            return root;
        }
        
        int leftVal = pre[preStart + 1];
        
        int mirrorLeftRootIdx = mirrorStart + 1;
        while (mirrorLeftRootIdx <= mirrorEnd && preMirror[mirrorLeftRootIdx] != leftVal) {
            mirrorLeftRootIdx++;
        }
        
        int leftSubtreeSize = mirrorEnd - mirrorLeftRootIdx + 1;
        
        root.left = build(pre, preMirror, preStart + 1, preStart + leftSubtreeSize, mirrorLeftRootIdx, mirrorEnd);
        root.right = build(pre, preMirror, preStart + leftSubtreeSize + 1, preEnd, mirrorStart + 1, mirrorLeftRootIdx - 1);
        
        return root;
    
    }
}