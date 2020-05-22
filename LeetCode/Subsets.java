class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        getSubsets(results, new ArrayList<>(), nums, 0);
        
        return results;
    }
    
    private void getSubsets(List<List<Integer>> results,List<Integer> buffer, int[] nums ,int startIndex){
        results.add(new ArrayList<>(buffer));
        
        for(int i = startIndex; i < nums.length; i++){
            buffer.add(nums[i]);
            getSubsets(results,buffer,nums,i + 1);
            buffer.remove(buffer.size() - 1);
        }
    }
}