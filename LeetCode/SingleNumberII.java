class Solution {
    public int singleNumber(int[] nums) {
        
        if(nums.length < 1)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 0;
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            if(entry.getValue() == 1){
                n = entry.getKey();
            }
        }
        return n;
    }
}