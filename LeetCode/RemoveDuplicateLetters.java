class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] dict = new int[26];
        boolean[] visited = new boolean[26];
        
        char[] ch = s.toCharArray();
        
        for(char c : ch){
            
            dict[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        
        int index;
        
        for(char c : ch){
            
            index = c - 'a';
            dict[index]--;
            if(visited[index])
                continue;
            while(!stack.isEmpty() && c < stack.peek() && dict[stack.peek() - 'a'] != 0){
                
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
           sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}