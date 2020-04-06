class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int total_length = nums1.length + nums2.length;
        
        int indexOfMedian = total_length / 2;
        
        int i = 0, j = 0;
        int start = 0, end = 0;
        
        for(int pos = 0; pos <= indexOfMedian; pos++){
            
            int value = 0;
            if(i < nums1.length && (j>=nums2.length || nums1[i] <=nums2[j])){
                
                value = nums1[i];
                i++;
            } else {
                
                value = nums2[j];
                j++;
            }
            
            if(pos == indexOfMedian - 1){
                start = value;
            } else {
                end = value;
            }
        }
        
        boolean isEven = total_length % 2 == 0;
        
        if(isEven){
            
            return((double) start + (double) end ) / 2;
        } else {
            
            return end;
        }
    }
}