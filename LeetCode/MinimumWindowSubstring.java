class Solution {
    public String minWindow(String s, String t) {
        
        if(s == null || t.length() > s.length())
            return "";
        int[] map = new int[128];
        
        for(char c : t.toCharArray()){
            map[c]++;
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        
        while(end < s.length()){
            
            char c1 = s.charAt(end);
            if(map[c1] > 0) counter--;
            
            map[c1]--;
            end++;
            
            while(counter == 0){
                
                if(minLen > end - start){
                    
                    minLen = end - start;
                    minStart = start;
                }
                
                char c2  = s.charAt(start);
                map[c2]++;
                if(map[c2] > 0) counter++;
                start++;
            }
            
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        
    }
}