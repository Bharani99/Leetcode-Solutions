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
    int ans = 0;
    public void goodNodes(TreeNode curr, int val){
        if(curr == null) return;
        if(curr.val >= val) ans++;
        goodNodes(curr.left, Math.max(val, curr.val));
        goodNodes(curr.right, Math.max(val, curr.val));
    }
    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return ans;
    }
}