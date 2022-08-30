class Solution {
    
    public void rotate(int[][] matrix, int i, int j, int x, int y, int m, int n, int mn){
        if(mn == 4) return;
        int val = matrix[i][j];
        rotate(matrix, x, y, y, n - 1 - x, m, n, mn + 1);
        matrix[x][y] = val - 3000;
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] <= 1000 && matrix[i][j] >= -1000)
                    rotate(matrix, i, j, j, n - 1 - i, n, n, 0);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] += 3000;
            }
        }
    }
}