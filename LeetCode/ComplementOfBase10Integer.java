class Solution {
    public int bitwiseComplement(int N) {
        
        if(N == 0) return 1;
    
        int number = N;
        int bit = 1;
        
        while(number != 0){
            
            N = N ^ bit;
            
            bit = bit << 1;
            number = number >> 1;
        }
        
        return N;
    }
}