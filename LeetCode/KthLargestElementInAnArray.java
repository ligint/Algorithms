class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 || k <= 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> {
            return n1 - n2;
        });
        
        for(int i = 0; i < nums.length; i++){
            
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}