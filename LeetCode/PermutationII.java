class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        Arrays.sort(nums);
        getPermutation(results, new ArrayList<>(), nums, new boolean[nums.length]);
        
        return results;
    }
    
    private void getPermutation(List<List<Integer>> results, List<Integer> buffer, int[] nums,boolean[] visited){
        if(buffer.size() == nums.length){
            results.add(new ArrayList<>(buffer));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                buffer.add(nums[i]);
                getPermutation(results,buffer,nums,visited);
                visited[i] = false;
                buffer.remove(buffer.size() - 1);
        }
    }
}