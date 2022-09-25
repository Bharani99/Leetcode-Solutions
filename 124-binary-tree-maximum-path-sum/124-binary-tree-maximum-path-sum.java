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
    int max = Integer.MIN_VALUE;
    public int maxTree(TreeNode curr){
        if(curr == null) return 0;
        int sum = curr.val;
        int left = maxTree(curr.left), right = maxTree(curr.right);
        sum = Math.max(sum, Math.max(sum + left, sum + right));
        max = Math.max(max, Math.max(sum, curr.val + left + right));
        return sum;
    }
    public int maxPathSum(TreeNode root) {
        maxTree(root);
        return max;
    }
}