class Solution {
    int[] next = new int[]{0, -1, 0, 1, 0};
    
    public boolean isValid(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
    
    public int shortestPath(int[][] grid, int K) {
        int m = grid.length - 1, n = grid[0].length - 1;
        int[][][] seen = new int[m + 1][n + 1][K + 1];
        
        Queue<int[]> q = new LinkedList<>();
        //i, j, k, steps
        q.add(new int[]{0, 0, K - grid[0][0], 0});
        int i, j, k;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[2] < 0) continue;
            i = curr[0];
            j = curr[1];
            k = curr[2];
            if(i == m && j == n) return curr[3];
            if(seen[i][j][k] == 1) continue;
            seen[i][j][k] = 1;
            
            for(int x = 0; x < 4; x++){
                int nexti = i + next[x], nextj = j + next[x + 1];
                if(isValid(grid, nexti, nextj))
                    q.add(new int[]{nexti, nextj, k - grid[nexti][nextj], curr[3] + 1});
            }
        }
        
        return -1;
    }
}