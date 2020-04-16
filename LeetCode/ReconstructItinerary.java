class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
    
        HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        
        for(List<String> ticket : tickets){
            
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            if(flightMap.containsKey(from)){
                
                LinkedList<String> destList = flightMap.get(from);
                destList.add(to);   
            } else {
                
                LinkedList<String> destList = new LinkedList<>();
                destList.add(to);
                flightMap.put(from, destList);
            }
        }
            
        flightMap.forEach((key,value) -> Collections.sort(value));
            
        DFS("JFK", flightMap, result);
            
        return result;
    }
    
    public void DFS(String from ,HashMap<String, LinkedList<String>> flightMap, LinkedList<String> result){
        
        if(flightMap.containsKey(from)){
            
            LinkedList<String> destList = flightMap.get(from);
            while(!destList.isEmpty()){
                
                String dest = destList.pollFirst();
                DFS(dest, flightMap,result);
            }
        }
        
        result.offerFirst(from);
    }
        
}