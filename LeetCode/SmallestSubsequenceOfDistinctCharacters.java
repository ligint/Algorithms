class Solution {
    public String smallestSubsequence(String text) {
        
        int[] dict = new int[26];
        boolean[] visited = new boolean[26];
        
        char[] ch = text.toCharArray();
        Stack<Character> s = new Stack<>();
        
        for(char c : ch){
            
            dict[c -'a']++;
        }
        
        int index;
        
        for(char c : ch){
            
            index = c - 'a';
            dict[index]--;
            
            if(visited[index])
                continue;
            while(!s.isEmpty() && c < s.peek() && dict[s.peek() - 'a'] != 0){
                
                visited[s.pop() - 'a'] = false;
            }
            
            s.push(c);
            visited[index] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0,s.pop());
        }
        return sb.toString();
    }
}