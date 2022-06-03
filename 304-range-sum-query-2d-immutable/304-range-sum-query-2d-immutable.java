class NumMatrix {

    int[][] cache;
    int ans;
    
    public NumMatrix(int[][] matrix) {
        cache = new int[matrix.length][matrix[0].length];
        int sum;
        for(int i = 0; i < matrix.length; i++){
            sum = 0;
            for(int j = matrix[i].length - 1; j >= 0; j--){
                sum += matrix[i][j];
                cache[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        ans = 0;
        for(int i = row1; i <= row2; i++){
            ans += cache[i][col1];
            if(col2 + 1 < cache[0].length)
                ans -= cache[i][col2 + 1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */