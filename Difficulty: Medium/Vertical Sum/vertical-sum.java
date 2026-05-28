import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        calculateSum(root, 0, map);
        for (int sum : map.values()) {
            result.add(sum);
        }
        return result;
    }

    private void calculateSum(Node node, int hd, TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        calculateSum(node.left, hd - 1, map);
        calculateSum(node.right, hd + 1, map);
    }
}