class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> results = new ArrayList<>();
        
        if(n == 0)
            return results;
        
        backtrack(results,"",0,0,n);
        return results;
    }
    
    public void backtrack(List<String> results, String current, int open, int close, int max){
        if(current.length() == max * 2){
            
            results.add(current);
            return;
        }
        
        if(open < max)
            backtrack(results,current + "(", open + 1, close, max);
        if(close < open)
            backtrack(results,current + ")", open, close + 1, max);
        
    }
}