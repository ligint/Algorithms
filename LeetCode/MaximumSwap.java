class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        
        int[] result = new int[10];
        
        for(int i = 0; i < A.length; i++){
            result[A[i] - '0'] = i;
        }
        
        for(int i = 0; i < A.length; i++){
            for(int d = 9; d > A[i] - '0'; d--){
                if(result[d] > i){
                    char tmp = A[i];
                    A[i] = A[result[d]];
                    A[result[d]] = tmp;
                    
                    return Integer.valueOf(new String(A));
                }
            }
        }
        
        return num;
    }
}