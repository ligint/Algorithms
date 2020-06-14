class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        HashMap<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights){
            if(!map.containsKey(flight[0]))
                map.put(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[0],b[0])));
        pq.add(new int[] {0, src, K + 1});
        
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            
            if(city == dst) return price;
            
            if(stops > 0){
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap<>());
                for(int a : adj.keySet()){
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}