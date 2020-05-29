class Solution {
    public int[] sortedSquares(int[] A) {
     
        int n = A.length;
        
        int[] result = new int[n];
        
        int left = 0, right = n - 1;
        int index = n - 1;
        
        while(left <= right){
            
            if(Math.abs(A[left]) > Math.abs(A[right])){
                result[index] = A[left] * A[left];
                left++;
            } else{
                result[index] = A[right] * A[right];
                right--;
            }
            
            index--;
        }
        return result;
    }
}