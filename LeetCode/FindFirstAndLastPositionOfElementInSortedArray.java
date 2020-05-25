class Solution {
    public int[] searchRange(int[] nums, int target) {
     
        int[] output = {-1, -1};
        
        int left = binarySearch(nums, target, true);
        
        if(left == nums.length || nums[left] != target){
            return output;
        }
        
        output[0] = left;
        output[1] = binarySearch(nums,target, false) - 1;
        
        return output;
    }
    
    public int binarySearch(int[] nums, int target, boolean left){
        
        int low = 0;
        int high = nums.length;
        
        while(low < high){
            
            int mid = low + (high - low) / 2;
            
            if(nums[mid] > target || (left && target == nums[mid])){
                high = mid;
            } else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}