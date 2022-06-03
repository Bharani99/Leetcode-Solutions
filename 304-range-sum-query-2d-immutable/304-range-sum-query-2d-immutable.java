class NumMatrix {

    int[][] cache;
    int ans;
    
    public NumMatrix(int[][] matrix) {
        cache = new int[matrix.length][matrix[0].length];
        int sum;
        for(int i = matrix.length - 1; i >= 0; i--){
            sum = 0;
            for(int j = matrix[i].length - 1; j >= 0; j--){
                sum += matrix[i][j];
                cache[i][j] = sum;
                if(i + 1 < matrix.length)
                    cache[i][j] += cache[i + 1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        ans = cache[row1][col1];
        if(row2 + 1 < cache.length)
            ans -= cache[row2 + 1][col1];
        if(col2 + 1 < cache[0].length)
            ans -= cache[row1][col2 + 1];
        if(row2 + 1 < cache.length && col2 + 1 < cache[0].length)
            ans += cache[row2 + 1][col2 + 1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */