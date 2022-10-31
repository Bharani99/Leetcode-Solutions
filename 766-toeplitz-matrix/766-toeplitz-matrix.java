class Solution {
    public boolean isValid(int[][] matrix, int i, int j){
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
    
    public boolean isToeplitz(int[][] matrix, int i, int j, int val){
        if(!isValid(matrix, i, j)) return true;
        return matrix[i][j] == val && isToeplitz(matrix, i + 1, j + 1, val);
    }
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int j = 0; j < matrix[0].length; j++){
            if(!isToeplitz(matrix, 0, j, matrix[0][j]))
                return false;
        }
        
        for(int i = 1; i < matrix.length; i++)
            if(!isToeplitz(matrix, i, 0, matrix[i][0]))
                return false;
        
        return true;
    }
}