class Solution {
    public int closedIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
       int dr = grid.length;
       int dc = grid[0].length;
        
        int count = 0;
        
        for(int row = 0; row < dr; row++){
            for(int col = 0; col < dc; col++){
                if(grid[row][col] == 0 && dfs(grid,row,col)){
                    
                    count++;
                    
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int[][] grid, int row, int col){
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        if(row < 0 || col < 0 || row >= nr || col >= nc){
            
            return false;
        }
        
        if(grid[row][col] == 1){
            
            return true;
        }
        
        grid[row][col] = 1;
        
        return dfs(grid,row - 1,col) & dfs(grid,row + 1,col) & dfs(grid,row ,col - 1) & dfs(grid,row ,col + 1); 
    }
}