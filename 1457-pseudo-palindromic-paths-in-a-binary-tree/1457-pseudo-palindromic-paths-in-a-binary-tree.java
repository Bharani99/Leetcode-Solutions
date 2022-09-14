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
    public int isPalindrome(int[] count){
        int odd = 1;
        for(int i = 0; i < 10; i++){
            if(count[i] % 2 == 1) odd--;
            if(odd < 0) return 0;
        }
        return 1;
    }
    
    public void pseudoPalindrome(TreeNode curr, int[] count){
        if(curr == null) return;
        count[curr.val]++;
        if(curr.left == null && curr.right == null) ans += isPalindrome(count);
        else{
            pseudoPalindrome(curr.left, count);
            pseudoPalindrome(curr.right, count);
        }
        count[curr.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        pseudoPalindrome(root, new int[10]);
        return ans;
    }
}