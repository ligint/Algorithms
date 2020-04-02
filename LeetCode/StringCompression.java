class Solution {
    public int compress(char[] chars) {
        
        int indexAns = 0, index = 0;
        
        while(index < chars.length){
            
            char current = chars[index];
            int count = 0;
            
            while(index < chars.length && chars[index] == current){
                
                index++;
                count++;
            }
            
            chars[indexAns++] = current;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
            
        }
        return indexAns;
    }
}