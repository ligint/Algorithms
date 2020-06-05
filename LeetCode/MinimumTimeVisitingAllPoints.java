class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        
        for(int i = 1; i < points.length; i++){
            int[] start = points[i];
            int[] next = points[i - 1];
            minTime += Math.max(Math.abs(start[0] - next[0]) , Math.abs(start[1] - next[1]));
        }
        return minTime;
    }
}