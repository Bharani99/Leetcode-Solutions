class Solution {
    List<List<String>> output = new ArrayList<>();
    
    public boolean isValid(int[] finishedRow, int[] finishedCol, int[] maxDiag, int[] minDiag, int row, int col){
        return finishedRow[row] == 0 && finishedCol[col] == 0 && minDiag[row + col] == 0 && maxDiag[col - row + finishedRow.length] == 0;
    }
    
    public void addToOutput(char[][] board){
        List<String> out = new ArrayList<>();
        for(char[] row : board)
            out.add(new String(row));
        output.add(out);
    }
    
    public void solve(char[][] board, int[] finishedRow, int[] finishedCol, int[] maxDiag, int[] minDiag, int row){
        if(row == board.length){
            addToOutput(board);
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(isValid(finishedRow, finishedCol, maxDiag, minDiag, row, col)){
                board[row][col] = 'Q';
                finishedRow[row] = 1;
                finishedCol[col] = 1;
                maxDiag[col - row + board.length] = 1;
                minDiag[row + col] = 1;
                solve(board, finishedRow, finishedCol, maxDiag, minDiag, row + 1);
                board[row][col] = '.';
                finishedRow[row] = 0;
                finishedCol[col] = 0;
                maxDiag[col - row + board.length] = 0;
                minDiag[row + col] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');
        solve(board, new int[n], new int[n], new int[n + n], new int[n + n], 0);
        return output;
    }
}