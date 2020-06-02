class Solution {
    public String convert(String s, int numRows) {
     
        int n = s.length();
        
        if(numRows  > n || numRows <= 1)
            return s;
        
        StringBuilder sb = new StringBuilder();
        
        int interval = 2 * numRows - 2;
        
        for(int i = 0; i < numRows; i++){
            int step = interval - 2 * i;
            for(int j = i; j < n ; j += interval){
                sb.append(s.charAt(j));
                if(step > 0 && step < interval && j + step < n){
                    sb.append(s.charAt(j + step));
                }
            }
        }
        
        return sb.toString();
    }
}