class Solution {
    
    public int dfs(int[][] grid, int row, int col, boolean[][] seen){
        
        int dr = grid.length;
        int dc = grid[0].length;
        
        if(row < 0 || col < 0 || row >= dr || col >= dc || seen[row][col] || grid[row][col] == 0){
            return 0;
        }
        
        seen[row][col] = true;
        
        return(1 + dfs(grid, row + 1, col, seen) + dfs(grid, row - 1, col, seen) + dfs(grid, row , col - 1, seen) + dfs(grid, row , col + 1, seen));
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0){
            
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        int maxArea = 0;
        
        boolean[][] seen = new boolean[nr][nc]; 
        
        for(int row = 0; row < nr; row++){
            for(int col = 0; col < nc; col++){
                
                if(grid[row][col] == 1){
                    
                    maxArea = Math.max(maxArea, dfs(grid,row,col,seen));
                }
            }
        }
        
        return maxArea;
    }
}