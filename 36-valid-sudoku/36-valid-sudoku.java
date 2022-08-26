class Solution {
    public boolean isValidSudoku(char[][] board) {
        int curr, x, y;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                
                curr = board[i][j];
                for(int k = 0; k < board.length; k++)
                    if(k != i && curr == board[k][j]) return false;
                
                
                for(int k = 0; k < board[0].length; k++)
                    if(k != j && curr == board[i][k]) return false;
                
                if(i < 3) x = 0;
                else if(i >= 3 && i < 6) x = 3;
                else x = 6;
                
                if(j < 3) y = 0;
                else if(j >= 3 && j < 6) y = 3;
                else y = 6;
                
                int count = 0;
                for(int p = x; p < x + 3; p++){
                    for(int q = y; q < y + 3; q++){
                        if(board[p][q] == curr) count++;
                    }
                }
                if(count > 1) return false;
            }
        }
        return true;
    }
}