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
    public boolean findTarget(TreeNode curr, int k, HashSet<Integer> set){
        if(curr == null) return false;
        if(set.contains(k - curr.val)) return true;
        set.add(curr.val);
        return findTarget(curr.left, k, set) || findTarget(curr.right, k, set);
    }
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, k, new HashSet<>());
    }
}