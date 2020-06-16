class Solution {
    public List<List<String>> partition(String s) {
     
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0);
        
        return results;
    }
    
    private void backtrack(List<List<String>> results, List<String> buffer, String s, int start){
        if(start == s.length())
            results.add(new ArrayList<>(buffer));
        
        for(int i = start; i < s.length(); i++){
            
            if(isPalindrome(s,start, i)){
                buffer.add(s.substring(start, i + 1));
                backtrack(results, buffer, s, i + 1);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}