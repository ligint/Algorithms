class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(0);
        visited.add(0);
        
        int depth = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            depth++;
            for(int i = 0; i < size; i++){
                
                int num = q.poll();
                for(int j = 1; j * j <= n; j++){
                    
                    int sum = num + j * j;
                    
                    if(sum == n){
                        return depth;
                    }
                    if(sum > n){
                        break;
                    }
                    if(!visited.contains(sum)){
                        q.offer(sum);
                        visited.add(sum);
                    }
                }
            }
            
        }
        return depth;
    }
}