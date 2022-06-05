class Solution {
    
    int output = 0;
    
    public boolean isValid(int[] finishedRow, int[] finishedCol, int[] maxDiag, int[] minDiag, int row, int col){
        return finishedRow[row] == 0 && finishedCol[col] == 0 && minDiag[row + col] == 0 && maxDiag[col - row + finishedRow.length] == 0;
    }
    
    
    public void solve(int[] finishedRow, int[] finishedCol, int[] maxDiag, int[] minDiag, int row){
        if(row == finishedRow.length){
            output++;
            return;
        }
        for(int col = 0; col < finishedRow.length; col++){
            if(isValid(finishedRow, finishedCol, maxDiag, minDiag, row, col)){
                finishedRow[row] = 1;
                finishedCol[col] = 1;
                maxDiag[col - row + finishedRow.length] = 1;
                minDiag[row + col] = 1;
                solve(finishedRow, finishedCol, maxDiag, minDiag, row + 1);
                finishedRow[row] = 0;
                finishedCol[col] = 0;
                maxDiag[col - row + finishedRow.length] = 0;
                minDiag[row + col] = 0;
            }
        }
    }
    
    public int totalNQueens(int n) {
        solve(new int[n], new int[n], new int[n + n], new int[n + n], 0);
        return output;
    }
}