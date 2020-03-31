class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidIndex = new HashSet<>();
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } if(s.charAt(i) ==')'){
                if(stack.isEmpty()){
                    invalidIndex.add(i);
                } else{
                    
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) invalidIndex.add(stack.pop());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!invalidIndex.contains(i)){
                
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}