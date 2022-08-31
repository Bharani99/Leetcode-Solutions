class Solution {
    int[] next = new int[]{0, -1, 0, 1, 0};
    
    public boolean isValid(int[][] h, int i, int j){
        return i >= 0 && j >= 0 && i < h.length && j < h[0].length;
    }
    
    public void solve(int[][] h, boolean[][] visited, int i, int j, int prevH){
        if(!isValid(h, i, j) || h[i][j] < prevH) return;
        if(visited[i][j]) return;
        
        visited[i][j] = true;
        for(int k = 0; k < 4; k++)
            solve(h, visited, i + next[k], j + next[k + 1], h[i][j]);
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        
        boolean[][] p = new boolean[m][n], a = new boolean[m][n];
        for(int j = 0; j < n; j++){
            solve(heights, p, 0, j, Integer.MIN_VALUE);
            solve(heights, a, m - 1, j, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < m; i++){
            solve(heights, p, i, 0, Integer.MIN_VALUE);
            solve(heights, a, i, n - 1, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p[i][j] && a[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        
        return res;
    }
}