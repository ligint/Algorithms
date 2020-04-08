class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                indegree.put(c,0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            
            String first = words[i];
            String second = words[i + 1];
            
            if(first.length() > second.length() && first.startsWith(second)){
                return "";
            }
            
            int length = Math.min(first.length(), second.length());
            
            for(int j = 0; j < length; j++){
                
                char a = first.charAt(j);
                char b = second.charAt(j);
                
                if(a != b){
                    
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(a))
                        set = map.get(a);
                    if(!set.contains(b)){
                        set.add(b);
                        map.put(a,set);
                        indegree.put(b,indegree.get(b) + 1);
                    }
                    
                    break;
                }
            }
        }
            
            Queue<Character> q = new LinkedList<>();
            for(char c : indegree.keySet()){
                if(indegree.get(c) == 0)
                    q.add(c);
            }
            
            while(!q.isEmpty()){
                char c = q.remove();
                sb.append(c);
                if(map.containsKey(c)){
                    for(char next : map.get(c)){
                        
                        indegree.put(next,indegree.get(next) - 1);
                        if(indegree.get(next) == 0)
                            q.add(next);
                    }
                }
                
            }
        if(sb.toString().length() != indegree.size())
            return "";
        
        return sb.toString();
    }
}