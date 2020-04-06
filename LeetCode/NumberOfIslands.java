class Solution {
    
    
    private void dfs(char[][] grid , int row , int col){
        
        int dr = grid.length;
        int dc = grid[0].length;
        
        if(row < 0 || col < 0 || row >= dr || col >= dc || grid[row][col] == '0'){
            return;
        }
            
        grid[row][col] = '0';
        dfs(grid , row + 1, col);
        dfs(grid , row - 1 ,col);
        dfs(grid , row, col + 1);
        dfs(grid , row, col - 1);
        
    }
    
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int gr = grid.length;
        int gc = grid[0].length;
        
        int numberOfIslands = 0;
        
        for(int row = 0; row < gr; row++){
            for(int col = 0; col < gc; col++){
                
                if(grid[row][col] == '1'){
                    
                    numberOfIslands++;
                    dfs(grid,row,col);
                    
                }
                
            }
        }
        return numberOfIslands;
    }
}