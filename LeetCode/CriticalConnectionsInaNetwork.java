class Solution {
    
    int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if(n == 0 || connections.size() == 0){
            return results;
        }
            
        
        List<Integer>[] graph = new List[n];
        
        for(List<Integer> conn : connections){
            
            int from = conn.get(0);
            int to = conn.get(1);
            
            if(graph[from] == null){
                
                graph[from] = new ArrayList<>(); 
            }
            
            if(graph[to] == null){
                
                graph[to] = new ArrayList<>(); 
            }
            
            graph[from].add(to);
            graph[to].add(from);
            
        }
        
        int[] disc = new int[n];
        int[] parents = new int[n];
        int[] low = new int[n];
        
        Arrays.fill(disc, -1);
        Arrays.fill(parents, -1);
        Arrays.fill(low, -1);
        
        for(int i = 0; i < n; i++){
            if(disc[i] == -1){
                dfs(i,parents,disc,low,graph,results);
            }
        }
        
        return results;
    }
    
    public void dfs(int current,int[] parents, int[] disc, int[] low, List<Integer>[] graph ,List<List<Integer>> results){
        
        if(disc[current] != -1)
            return;
        
        disc[current] = low[current] = time++;
        
        for(int v : graph[current]){
            
            if(disc[v] == -1){
                
                parents[v] = current;
                dfs(v,parents,disc,low,graph,results);
                
                if(disc[current] < low[v]){
                    
                    results.add(Arrays.asList(current,v));
                }
                
                low[current] = Math.min(low[current], low[v]);
                
            } else if(parents[current] != v){
                
                low[current] = Math.min(low[current], low[v]);
            }
        }
        
        
    }
}