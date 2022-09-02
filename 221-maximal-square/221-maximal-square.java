class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i > 0 && j > 0 && matrix[i][j] > '0')
                    matrix[i][j] = (char) ('0' + (matrix[i][j] - '0') + Math.min(matrix[i - 1][j] - '0', Math.min(matrix[i][j - 1] - '0', matrix[i - 1][j - 1] - '0'))) ;
                
                max = Math.max(max, matrix[i][j] - '0');
            }
        }
        return max * max;
    }
}