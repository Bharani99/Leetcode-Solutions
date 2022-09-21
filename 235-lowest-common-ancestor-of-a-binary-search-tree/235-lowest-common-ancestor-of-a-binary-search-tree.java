/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode getAncestor(TreeNode curr, TreeNode p, TreeNode q){
        if(curr == null) return null;
        
        if(curr == p || curr == q) return curr;
        
        if(curr.val > p.val && curr.val < q.val) return curr;
        
        if(curr.val > p.val) return getAncestor(curr.left, p, q);
        else return getAncestor(curr.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return (p.val < q.val) ? getAncestor(root, p, q) : getAncestor(root, q, p);
    }
}