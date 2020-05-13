class Solution {
    public int countBattleships(char[][] board) {
        
        int r = board.length;
        int c = board[0].length;
        
        if(r == 0)
            return 0;
        
        int count = 0;
        
        for(int row = 0; row < r; row++){
            for(int col = 0; col < c; col++){
                if(board[row][col] == '.')
                    continue;
                if(row > 0 && board[row - 1][col] == 'X') continue;
                if(col > 0 && board[row][col - 1] == 'X') continue;
                count++;
            }
        }
        
        return count;
    }
}