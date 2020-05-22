class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((n1,n2) -> (n2.getValue() - n1.getValue()));
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            for(int i = 0; i < (int) e.getValue();i++){
                sb.append(e.getKey());
            }
        }
        
        return sb.toString();
    }
}