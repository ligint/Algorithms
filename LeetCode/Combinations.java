class Solution {
    public List<List<Integer>> combine(int n, int k) {
     List<List<Integer>> results = new ArrayList<>();
    
     getCombinations(results, new ArrayList<>(), 1, n, k);
    
     return results;
    }
    
    public void getCombinations(List<List<Integer>> results, List<Integer> buffer, int startIndex, int n, int k){
        
        if(k == 0){
            results.add(new ArrayList<Integer>(buffer));
            return;
        }
        
        for(int i = startIndex; i <= n - k + 1; i++){
            buffer.add(i);
            getCombinations(results, buffer, i + 1, n, k - 1);
            buffer.remove(buffer.size() - 1);
        }
    }
}