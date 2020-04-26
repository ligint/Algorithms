class Solution {
    
    int maxGold = 0;
    
    public int getMaximumGold(int[][] grid) {
        
        int gr = grid.length;
        int gc = grid[0].length;
        
        for(int row = 0; row < gr; row++){
            for(int col = 0; col < gc; col++){
                if(grid[row][col] != 0){
                    dfs(grid, row, col, 0);
                }
            }
        }
        return maxGold;
    }
    
    public void dfs(int[][] grid, int r , int c, int current){
        
        int row = grid.length;
        int col = grid[0].length;
        
        if(r < 0 || c < 0 || r >=row || c >= col || grid[r][c] == 0){
            maxGold = Math.max(maxGold, current);
            return;
        }
        
        int val = grid[r][c];
        grid[r][c] = 0;
        dfs(grid, r + 1, c, current + val);
        dfs(grid, r - 1, c, current + val);
        dfs(grid, r, c + 1, current + val);
        dfs(grid, r, c - 1, current + val);
        
        grid[r][c] = val;
    }
}