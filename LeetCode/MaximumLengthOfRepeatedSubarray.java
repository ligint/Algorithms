class Solution {
    public int findLength(int[] A, int[] B) {
        
        int a = A.length, b = B.length;
        if(a == 0 || b == 0) return 0;
        
        int max = 0;
        int[][]dp = new int[a + 1][b + 1];
        
        for(int i = a - 1; i >=0 ; i--){
            for(int j = b - 1; j >=0 ; j--){
                
                max = Math.max(max, dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0);
            }
            
        }
        return max;
    }
}