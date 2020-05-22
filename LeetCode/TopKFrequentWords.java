class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if(words == null || words.length == 0 || k <= 0)
            return result;
        
        for(String s : words){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((n1,n2) -> (n1.getValue().equals(n2.getValue()) ? n2.getKey().compareTo(n1.getKey()): n1.getValue() - n2.getValue()));
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        
        while(!pq.isEmpty()){
            result.add(0,pq.poll().getKey());
        }
        
        return result;
    }
}