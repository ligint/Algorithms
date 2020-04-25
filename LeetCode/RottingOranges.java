class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i , j});
                }
                if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh == 0) return 0;
        
        int level = 0;
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
        
        while(!q.isEmpty()){
            
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                
                int[] rotten = q.poll();
                for(int[] dir: directions){
                    
                    int nx = dir[0] + rotten[0];
                    int ny = dir[1] + rotten[1];
                    
                    if(nx < 0 || ny < 0 || nx >= row || ny >= col || grid[nx][ny] != 1)
                        continue;
                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? level - 1: -1;
    }
}