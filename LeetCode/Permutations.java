class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        getPermuatation(results,new ArrayList<>(),nums);
        
        return results;
    }
    
    public void getPermuatation(List<List<Integer>> results, List<Integer> buffer, int[] nums){
        if(buffer.size() == nums.length){
            results.add(new ArrayList<>(buffer));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(buffer.contains(nums[i])) continue;
            buffer.add(nums[i]);
            //System.out.println(nums[i]);
            getPermuatation(results,buffer,nums);
            buffer.remove(buffer.size() - 1);
        }
    }
}