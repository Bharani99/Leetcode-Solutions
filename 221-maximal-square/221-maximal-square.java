class Solution {
    public int maximalSquare(char[][] m) {
        int max = 0;
        int[][] matrix = new int[m.length][m[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = m[i][j] == '0' ? 0 : 1;
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i > 0 && j > 0 && matrix[i][j] > 0)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
                
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max * max;
    }
}