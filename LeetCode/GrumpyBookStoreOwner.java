class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
     
        int satisfied = 0, maxSatisfied = 0;
        
        for(int i = 0, j = 0; i < grumpy.length; i++){
            
            if(grumpy[i] == 0){
                
                satisfied += customers[i];
            }
            else{
                j += customers[i];
            }
            
            if(i >= X){
                
                j -= grumpy[i - X] * customers[i - X];
            }
            
            maxSatisfied = Math.max(j,maxSatisfied);
        }
        
        return satisfied + maxSatisfied;
    }
}