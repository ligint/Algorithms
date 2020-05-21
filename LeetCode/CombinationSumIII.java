class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();    
        
        if(k == 0 || n == 0)
            return results;
        
        getCombinations(results,new ArrayList<>(), k , n, 1,0);
        
        return results;
    }
    
    public void getCombinations(List<List<Integer>> results, List<Integer> buffer, int k , int n, int startIndex, int sum){
        if(sum > n || buffer.size() > k){
            return;
        }
        
        if(sum == n && buffer.size() == k){
            results.add(new ArrayList<>(buffer));
            return;
        }
        
        for(int i = startIndex;i<=9; i++){
            buffer.add(i);
            getCombinations(results,buffer,k ,n,i + 1, sum + i);
            buffer.remove(buffer.size() - 1);
        }
    }
}