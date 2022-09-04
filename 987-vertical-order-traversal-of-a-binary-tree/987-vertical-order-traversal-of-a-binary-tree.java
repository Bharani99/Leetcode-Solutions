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
    
    public class CompNode {
        int row, col;
        TreeNode node;
        CompNode(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //row, col, val
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[1] == b[1]){
                if(a[0] == b[0])
                    return Integer.compare(a[2], b[2]);
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        Queue<CompNode> q = new LinkedList<>();
        q.add(new CompNode(0, 0, root));
        
        int size = 0;
        CompNode curr;
        while(!q.isEmpty()){
            size = q.size();
            for(int i = 0; i < size; i++){
                curr = q.poll();
                pq.add(new int[]{curr.row, curr.col, curr.node.val});
                if(curr.node.left != null) q.add(new CompNode(curr.row + 1, curr.col - 1, curr.node.left));
                if(curr.node.right != null) q.add(new CompNode(curr.row + 1, curr.col + 1, curr.node.right));
            }
        }
        
        List<List<Integer>> output = new ArrayList<>();
        int level = pq.peek()[1];
        List<Integer> inner = new ArrayList<>();
        int[] node;
        while(!pq.isEmpty()){
            node = pq.poll();
            if(node[1] == level){
                inner.add(node[2]);
            }
            else{
                output.add(inner);
                inner = new ArrayList<>();
                inner.add(node[2]);
                level = node[1];
            }
        }
        output.add(inner);
        return output;
    }
}