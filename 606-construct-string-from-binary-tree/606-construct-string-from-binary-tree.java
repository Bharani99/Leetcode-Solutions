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
    public void construct(TreeNode curr, StringBuilder sb){
        if(curr == null) return;
        sb.append("(" + curr.val);
        construct(curr.left, sb);
        if(curr.left == null && curr.right != null) sb.append("()");
        construct(curr.right, sb);
        sb.append(")");
    }
    public String tree2str(TreeNode curr) {
        StringBuilder ans = new StringBuilder();
        ans.append(curr.val);
        construct(curr.left, ans);
        if(curr.left == null && curr.right != null) ans.append("()");
        construct(curr.right, ans);
        return ans.toString();
    }
}