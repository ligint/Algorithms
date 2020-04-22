class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] < 0){
                
                results.add(Math.abs(index + 1));    
            }
            
            nums[index] = -nums[index];
        }
        return results;
    }
}