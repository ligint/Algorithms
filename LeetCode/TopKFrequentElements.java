class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0)
            return null;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((n1, n2) -> (n2.getValue() - n1.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        
        List<Integer> output = new ArrayList<>();
        while(output.size() < k){
            Map.Entry<Integer, Integer> entry = pq.poll();
            output.add(entry.getKey());
        }
        
        return output.stream().mapToInt(i->i).toArray();
    }
}