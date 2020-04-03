class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        
        remove(s, result, 0, 0, new char[]{'(',')'});
        return result;
        
    }
    
    private void remove(String s, List<String> ans, int last_i, int last_j, char[] parameters){
        for(int a = 0, i = last_i; i < s.length(); i++){
            if(s.charAt(i) == parameters[0]) a++;
            if(s.charAt(i) == parameters[1]) a--;
            if(a >=0) continue;
            
            for(int j = last_j; j <= i; j++){
                if(s.charAt(j) == parameters[1] && (j == last_j || s.charAt(j - 1) != parameters[1]))
                    remove(s.substring(0,j) + s.substring(j + 1, s.length()), ans, i, j, parameters);    
            }
             return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(parameters[0] == '(')
            remove(reversed, ans, 0, 0, new char[]{')','('});
        else
            ans.add(reversed);
    }
}