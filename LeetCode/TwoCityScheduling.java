class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int N = costs.length/2;
        int[] out = new int[N * 2];
        int minCost = 0, index = 0;
        
        for(int[] cost : costs){
            
            out[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        
        Arrays.sort(out);
        
        for(int i = 0; i < N; i++){
            minCost += out[i];
        }
        
        return minCost;
    }
}