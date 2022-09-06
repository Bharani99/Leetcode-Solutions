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
    public boolean saveNode(TreeNode curr){
        if(curr == null) return false;
        boolean output = curr.val == 1;
        if(!saveNode(curr.left)) curr.left = null;
        if(!saveNode(curr.right)) curr.right = null;
        return output || (curr.left != null) || (curr.right) != null;
    }
    public TreeNode pruneTree(TreeNode root) {
        return saveNode(root) ? root : null;
    }
}