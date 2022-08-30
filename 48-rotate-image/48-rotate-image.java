class Solution {
    public void rotate(int[][] matrix, int i, int j, int x, int y, int n, int mn){
        if(mn == 4) return;
        int val = matrix[i][j];
        rotate(matrix, x, y, y, n - 1 - x, n, mn + 1);
        matrix[x][y] = val;
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length, left = 0, right = n - 1, up = 0;
        while(left < right){
            for(int i = left; i < right; i++)
                rotate(matrix, up, i, i, n - 1 - up, n, 0);
            left ++;
            right --;
            up ++;
        }
    }
}