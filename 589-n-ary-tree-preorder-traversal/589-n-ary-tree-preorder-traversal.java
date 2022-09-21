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
    public void preorder(Node curr, List<Integer> list){
        list.add(curr.val);
        for(Node kid : curr.children)
            preorder(kid, list);
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        preorder(root, ans);
        return ans;
    }
}