class Solution {
    int ans = Integer.MIN_VALUE;
    
    public int getColVal(int rowStart, int rowEnd, int col, int[][] colSum){
        int ans = colSum[rowEnd][col];
        if(rowStart > 0) ans -= colSum[rowStart - 1][col];
        return ans;
    }
    
    public int getRowVal(int colStart, int colEnd, int row, int[][] rowSum){
        int ans = rowSum[row][colEnd];
        if(colStart > 0) ans -= rowSum[row][colStart - 1];
        return ans;
    }
    
    public void getMaxSum(int startRow, int startCol, int endRow, int endCol, int[][] rowSum, int[][] colSum, int currSum, int k, int[][] visited){
        if(currSum <= k && currSum > ans) ans = currSum;
        if(visited[endRow][endCol] == 1) return;
        visited[endRow][endCol] = 1;
        if(endCol + 1 < rowSum[0].length)
            getMaxSum(startRow, startCol, endRow, endCol + 1, rowSum, colSum, currSum + getColVal(startRow, endRow, endCol + 1, colSum), k, visited);
        
        if(endRow + 1 < rowSum.length)
            getMaxSum(startRow, startCol, endRow + 1, endCol, rowSum, colSum, currSum + getRowVal(startCol, endCol, endRow + 1, rowSum), k, visited);
                
    }
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rowSum = new int[m][n];
        int[][] colSum = new int[m][n];
        int sum = 0;
        for(int i = 0; i < m; i ++){
            sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix[i][j];
                rowSum[i][j] = sum;
            }
        }
        
        for(int i = 0; i < n; i ++){
            sum = 0;
            for(int j = 0; j < m; j++){
                sum += matrix[j][i];
                colSum[j][i] = sum;
            }
        }
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                visited = new int[m][n];
                getMaxSum(i, j, i, j, rowSum, colSum, matrix[i][j], k, visited);
            }
        }
        return ans;
    }
}