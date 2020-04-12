class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;
        
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            
            freq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
            
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(set.contains(s.charAt(i))){
                
                if(map.get(s.charAt(i)) != null){
                    
                    map.remove(s.charAt(i));
                    
                }
                
            } else {
                
                map.put(s.charAt(i) , i);
                set.add(s.charAt(i));
            }
            
        }
        
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
        
    }
}