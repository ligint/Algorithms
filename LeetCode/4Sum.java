class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    
    public List<List<Integer>> kSum(int[] nums, int start, int k, int target){
        
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        
        if(k == 2){
            
            int low = start, high = len - 1;
            while(low < high){
                
                int sum = nums[low] + nums[high];
                if(sum == target){
                    
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[low]);
                    path.add(nums[high]);
                    
                    results.add(path);
                    
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    while(low < high && nums[high] == nums[high - 1]) high--;
                    
                    low++;
                    high--;
                } else if(sum > target){
                    high--;
                } else{
                    low++;
                }
            }
        } else{
            
            for(int i = start; i < len - (k - 1); i++){
                
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for(List<Integer> t : temp){
                    
                    t.add(0, nums[i]);
                }
                
                results.addAll(temp);
            }
        }
        return results;
    }
}