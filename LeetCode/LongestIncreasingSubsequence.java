class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        
        int[] tails = new int[nums.length];
        int size = 0;
        
        for(int n : nums){
            int i = 0,j = size;
            
            while(i != j){
                
                int m = (i + j)/2;
                
                if(tails[m] < n)
                    i = m + 1;
                else
                    j = m;
            }
            
            tails[i] = n;
            if(i == size)
                size++;
        }
        
        return size;
        
    }
}