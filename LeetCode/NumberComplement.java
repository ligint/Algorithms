class Solution {
    public int findComplement(int num) {
        
        if(num == 0) return 1;
        
        int N = num;
        int bit = 1;
        
        while(N != 0){
            
            num = num ^ bit;
            
            bit = bit << 1;
            N = N >> 1;
        }
        return num;
    }
}