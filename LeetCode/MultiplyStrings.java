class Solution {
    public String multiply(String num1, String num2) {
        
        int a = num1.length(), b = num2.length();
        
        int[] index = new int[a + b];
        
        for(int i = a - 1; i >= 0; i--){
            for(int j = b - 1; j >= 0; j--){
                
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                
                int sum = product + index[p2];
                
                index[p1] += sum / 10;
                index[p2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int p : index)
            if(!(sb.length() == 0 && p == 0))
                sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}