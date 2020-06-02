class Solution {
    public int countCharacters(String[] words, String chars) {
        if(words.length < 1)
            return 0;
        
        int count = 0;
        int[] seen = new int[26];
        
        for(char c : chars.toCharArray()){
            
            seen[c - 'a']++; 
        }
        
        for(String word : words){
            
            int[] tseen = Arrays.copyOf(seen,seen.length);
            int tcount = 0;
            
            for(char c : word.toCharArray()){
                if(tseen[c - 'a'] > 0){
                    tseen[c - 'a']--;
                    tcount++;
                } else
                    break;
            }
            
            if(tcount == word.length()){
                count += tcount;
            }
        }
        
        return count;
    }
}