class Solution {

    private Map<Integer, Integer> map;
    int rows , cols , total;
    Random rand;
    
    public Solution(int n_rows, int n_cols) {
        
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows;
        cols = n_cols;
        reset();
    }
    
    public int[] flip() {
        
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total,total));
        map.put(total,x);
        
        return new int[]{ x / cols , x % cols };
    }
    
    public void reset() {
        total = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */