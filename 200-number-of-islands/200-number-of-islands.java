class Solution {
    
    int[] next = new int[]{0, -1, 0, 1, 0};
    
    public boolean isValid(char[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1';
    }
    
    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for(int k = 0; k < 4; k++){
            int nexti = i + next[k], nextj = j + next[k + 1];
            if(isValid(grid, nexti, nextj))
                dfs(grid, nexti, nextj);
        }
    }
    
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
}