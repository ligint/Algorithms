class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[] curr = new int[]{0,0};
        int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        int dir = 0;
        
        for(char c : instructions.toCharArray()){
            
            if(c == 'G'){
                
                curr[0] += dirs[dir][0];
                curr[1] += dirs[dir][1];
                
            } else if(c =='L'){
                
                dir = (dir + 3) % 4;
                
            } else {
                dir = (dir + 1) % 4;
            }
            
        }
        
        if(curr[0] == 0 && curr[1] == 0){
            return true;
        }
        
        if(dir == 0 && !(curr[0] == 0 && curr[1] == 0)){
            return false;
        }
        
        return true;
    }
}