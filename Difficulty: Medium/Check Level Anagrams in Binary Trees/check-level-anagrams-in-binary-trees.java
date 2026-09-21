class Solution {
public boolean areAnagrams(Node root1, Node root2) {
Queue<Node> q1 = new LinkedList<>();
Queue<Node> q2 = new LinkedList<>();

if (root1 != null) q1.add(root1);
if (root2 != null) q2.add(root2);

while (!q1.isEmpty() || !q2.isEmpty()) {
int s1 = q1.size();
int s2 = q2.size();

if (s1 != s2) return false;

Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < s1; i++) {
Node node = q1.poll();
map.put(node.data, map.getOrDefault(node.data, 0) + 1);
if (node.left != null) q1.add(node.left);
if (node.right != null) q1.add(node.right);
}

for (int i = 0; i < s2; i++) {
Node node = q2.poll();
Integer count = map.get(node.data);
if (count == null || count == 0) return false;

if (count == 1) {
map.remove(node.data);
} else {
map.put(node.data, count - 1);
}

if (node.left != null) q2.add(node.left);
if (node.right != null) q2.add(node.right);
}

if (!map.isEmpty()) return false;
}

return true;
}
}