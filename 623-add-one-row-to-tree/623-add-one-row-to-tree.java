/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode head = new TreeNode(val);
            head.left = root;
            return head;
        }
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        
        int size = 0;
        TreeNode curr, left, right;
        while(depth > 2){
            size = bfs.size();
            for(int i = 0; i < size; i++){
                curr = bfs.poll();
                if(curr.left != null) bfs.add(curr.left);
                if(curr.right != null) bfs.add(curr.right);
            }
            depth --;
        }
        
        while(!bfs.isEmpty()){
            curr = bfs.poll();
            left = curr.left;
            right = curr.right;
            curr.left = new TreeNode(val);
            curr.right = new TreeNode(val);
            curr.left.left = left;
            curr.right.right = right;
        }
        return root;
    }
}