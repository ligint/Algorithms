class Solution {
    
    List<Integer> psum = new ArrayList<>();
    int total = 0;
    Random rand = new Random();
    
    
    public Solution(int[] w) {
        
        for(int x : w){
            
            total += x;
            psum.add(total);
        }
        
    }
    
    public int pickIndex() {
        int target = rand.nextInt(total);
        
        int low = 0;
        int high = psum.size() - 1;
        
        while(low != high){
            
            int mid = (low + high) / 2;
            
            if(target >= psum.get(mid)) low = mid + 1;
            else high = mid;
        }
        
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */