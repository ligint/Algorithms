class WordDistance {

    public HashMap<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            if(map.containsKey(str)){
                map.get(str).add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(str, list);
            }
            
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int result = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        while(i < list1.size() && j < list2.size()){
            int index1 = list1.get(i), index2 = list2.get(j);
            
            if(index1 < index2){
                result = Math.min(result, index2 - index1);
                i++;
            } else{
                result = Math.min(result, index1 - index2);
                j++;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */