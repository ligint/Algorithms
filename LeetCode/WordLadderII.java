class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String,ArrayList<String>> neighbors = new HashMap<>();
        HashMap<String,Integer> distance = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        dict.add(beginWord);
        bfs(beginWord,endWord,dict,neighbors,distance);
        dfs(beginWord,endWord,dict,neighbors,distance,list,result);
        
        return result;
    }
    
    
    private void bfs(String start, String end, Set<String> dict, HashMap<String,ArrayList<String>> neighbors,HashMap<String,Integer> distance){
        
        for(String s : dict)
            neighbors.put(s,new ArrayList<String>());
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start,0);
        
        while(!q.isEmpty()){
            int count = q.size();
            boolean foundEnd = false;
            for(int i = 0; i < count; i++){
                String current = q.poll();
                int currDistance = distance.get(current);
                ArrayList<String> out = getNeighbors(current,dict);
                
                for(String n : out){
                    
                    neighbors.get(current).add(n);
                    if(!distance.containsKey(n)){
                        distance.put(n,currDistance + 1);
                        if(end.equals(n))
                            foundEnd = true;
                        else
                            q.offer(n);
                    }
                    
                }
            }
            if(foundEnd)
                break;
            
        }
    }  
    
    
    private ArrayList<String> getNeighbors(String node, Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        char[] c = node.toCharArray();
        
        for(char ch = 'a'; ch <='z'; ch++){
            for(int i = 0; i < c.length; i++){
                if(c[i] == ch) continue;
                
                char oldchar = c[i];
                c[i] = ch;
                
                if(dict.contains(String.valueOf(c))){
                    res.add(String.valueOf(c));
                }
                
                c[i] = oldchar;
            }
        }
        return res;
    }
    
    private void dfs(String cur, String end, Set<String> dict, HashMap<String,ArrayList<String>> neighbors,HashMap<String,Integer> distance, ArrayList<String> solution, List<List<String>> res){
        solution.add(cur);
        if(end.equals(cur)){
            res.add(new ArrayList<String>(solution));
        } else{
            for(String next : neighbors.get(cur)){
                if(distance.get(next) == distance.get(cur) + 1){
                    dfs(next,end,dict,neighbors,distance,solution,res);
                }
            }
            
        }
            
        solution.remove(solution.size() - 1);
        }
}