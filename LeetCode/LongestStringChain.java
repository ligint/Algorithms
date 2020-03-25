class Solution {
    public int longestStrChain(String[] words) {
    
        if(words == null || words.length == 0) return 0;
        
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        for(String word : words){
            if(map.containsKey(word)) continue;
            map.put(word,1);
            
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                String next = sb.deleteCharAt(i).toString();
                
                if(map.containsKey(next) && map.get(next) + 1 > map.get(word)){
                    map.put(word, map.get(next) + 1);
                }
            }
            
            result = Math.max(result,map.get(word));
        
        }
        
        return result;
        
    }
    
}