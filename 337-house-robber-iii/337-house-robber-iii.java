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
    public int rob(TreeNode curr, int canRob, HashMap<TreeNode, int[]> map){
        if(curr == null) return 0;
        if(map.containsKey(curr) && map.get(curr)[canRob] != -1) return map.get(curr)[canRob];
        int ans = 0;
        if(canRob == 1){
            ans = curr.val + rob(curr.left, 0, map) + rob(curr.right, 0, map);
        }
        ans = Math.max(ans, rob(curr.left, 1, map) + rob(curr.right, 1, map));
        int[] temp = map.getOrDefault(curr, new int[]{-1, -1});
        temp[canRob] = ans;
        map.put(curr, temp);
        return ans;
    }
    public int rob(TreeNode root) {
        
        return rob(root, 1, new HashMap<>());
    }
}