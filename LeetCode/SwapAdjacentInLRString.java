class Solution {
    public boolean canTransform(String start, String end) {
     
        int i = 0, j = 0;
        
        if(start.length() != end.length()) return false;
        
        while(i < start.length() && j < end.length()){
            while(i < start.length() && start.charAt(i) == 'X') i++;
            while(j < end.length() && end.charAt(j) == 'X') j++;
            
            if(i == start.length() || j == end.length()) break;
            if(start.charAt(i) != end.charAt(j)) return false;
            
            if(start.charAt(i) == 'R' && i > j) return false;
            else if(start.charAt(i) == 'L' && i < j) return false;
            
            i++;
            j++;
        }
                
        while(i < start.length() && start.charAt(i) == 'X') i++;
        while(j < end.length() && end.charAt(j) == 'X') j++;
        
        return i == j;
    }
}