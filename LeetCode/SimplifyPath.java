class Solution {
    public String simplifyPath(String path) {
        
        if(path.isEmpty())
            return path;
        
        Stack<String> stack = new Stack<>();
        String[] letters = path.split("/");
        
        
        for(String dir : letters){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            } else if(dir.equals("..")){
                
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else{
                stack.add(dir);
            }
        }
        
        StringBuilder output = new StringBuilder();
        for(String s : stack){
            output.append("/");
            output.append(s);
        }
        
        return output.length() > 0 ? output.toString() : "/";
    }
}