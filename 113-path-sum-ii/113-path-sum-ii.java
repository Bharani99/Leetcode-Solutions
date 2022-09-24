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
    public void pathSum(TreeNode curr, int target, int sum, List<List<Integer>> output, List<Integer> list){
        if(curr == null) return;
        list.add(curr.val);
        sum += curr.val;
        if(curr.left == null && curr.right == null && sum == target){
            output.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        pathSum(curr.left, target, sum, output, list);
        pathSum(curr.right, target, sum, output, list);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        pathSum(root, targetSum, 0, output, new ArrayList<>());
        return output;
    }
}