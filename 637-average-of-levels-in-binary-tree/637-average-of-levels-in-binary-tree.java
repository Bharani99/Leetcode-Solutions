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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);
        double sum = 0;
        ArrayList<Double> avg = new ArrayList<>();
        int size = 0;
        TreeNode curr;
        while(!levels.isEmpty()){
            sum = 0;
            size = levels.size();
            for(int i = 0; i < size; i++){
                curr = levels.poll();
                if(curr.left != null) levels.add(curr.left);
                if(curr.right != null) levels.add(curr.right);
                sum += curr.val;
            }
            avg.add(sum / size);
        }
        return avg;
    }
}