/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<Integer> level;
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        Node node;
        while(!q.isEmpty()){
            size = q.size();
            level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                node = q.poll();
                level.add(node.val);
                for(Node kid : node.children)
                    q.add(kid);
            }
            levels.add(level);
        }
        return levels;
    }
}