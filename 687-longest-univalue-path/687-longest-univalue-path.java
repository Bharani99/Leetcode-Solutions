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
    int max = 0;
    public int longestPath(TreeNode curr, int val){
        if(curr == null) return 0;
        int left = longestPath(curr.left, curr.val);
        int right = longestPath(curr.right, curr.val);
        max = Math.max(max, left + right);
        return (curr.val == val) ? Math.max(left, right) + 1 : 0;
    }
    public int longestUnivaluePath(TreeNode root) {
        longestPath(root, 1001);
        return max;
    }
}