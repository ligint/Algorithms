class Solution {
    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        if(candidates == null || candidates.length == 0 || target <= 0)
            return results;
        
        Arrays.sort(candidates);
        getCombinations(candidates,target, 0 , new Stack<Integer>(),0);
        
        return results;
    }
    
    public void getCombinations(int[] candidates, int target, int startIndex, Stack<Integer> buffer, int sum){
        if(sum > target){
            return;
        }
        
        if(sum == target){
            results.add(new ArrayList<>(buffer));
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(i > startIndex && candidates[i] == candidates[i - 1]) continue;
            buffer.push(candidates[i]);
            getCombinations(candidates,target, i + 1 ,buffer,sum + candidates[i]);
            buffer.pop();
        }
    }
}