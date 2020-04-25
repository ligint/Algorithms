class Solution {
    public int islandPerimeterdfs(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(grid[row][col] == 1){
                    
                    return dfs(grid,row,col);
                }
                
            }
        }
        return 0;
    }
    
    public int dfs(int[][] grid, int row, int col){
        
        int dr = grid.length;
        int dc = grid[0].length;
        
        if(row < 0 || col < 0 || row >= dr || col >= dc){
            return 1;
        }
        
        if(grid[row][col] == 0) return 1;
        if(grid[row][col] == -1) return 0;
        
        grid[row][col] = -1;
        
        return dfs(grid,row - 1,col) + dfs(grid,row + 1,col) + dfs(grid,row,col - 1) + dfs(grid,row,col + 1);
    }
	
	
    public int islandPerimeter(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        int result = 0;
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                if(grid[row][col] == 1){
                    
                    result += 4;
                    
                    if(row > 0 && grid[row - 1][col] == 1){
                        
                        result -=2;
                    }
                    if(col > 0 && grid[row][col - 1] == 1){
                        
                        result -=2;
                    }
                }
                
            }
        }
        return result;
    }
}