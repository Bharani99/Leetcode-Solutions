class Solution {
    int[][] dp, visited;
    
    public boolean isValid(int i, int j){
        return i >= 0 && j >= 0 && i < dp.length && j < dp[i].length;
    }
    
    public int countUniquePaths(int i, int j){
        if(i == dp.length - 1 && j == dp[i].length - 1) return 1;
        if(!isValid(i, j)) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(visited[i][j] == 1) return 0;
        
        visited[i][j] = 1;
        int right = countUniquePaths(i, j + 1), down = countUniquePaths(i + 1, j);
        
        dp[i][j] = right + down;
        return dp[i][j];
    }
    
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        visited = new int[m][n];
        return countUniquePaths(0, 0);
    }
}