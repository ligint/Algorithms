class Solution {
    public String lastSubstring(String s) {
        
        int n = s.length();
        
        int i = 0 , j = 1 , k = 0;
        
        
        while(i + k < n && j + k < n){
            
            if(s.charAt(i + k) == s.charAt(j + k)){
                k += 1;
                continue;
            }
            else if(s.charAt(i + k) > s.charAt(j + k)) {
                j = j + k + 1;
            }
            else{
                
                i = Math.max(i + k + 1, j);
                j = i + 1;
            }
            
            k = 0;
        }
        
        return s.substring(Math.min(i,j));
    }
}