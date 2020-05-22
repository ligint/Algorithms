class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
       
        int n = matrix.length;
        if(n == 0 || k <= 0)
            return 0;
        
        PriorityQueue<Point> pq = new PriorityQueue<>((n1,n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
       for(int i = 0; i < matrix.length && i < k; i++){
           pq.add(new Point(i , 0));
       }
        
        int numberCount = 0, result = 0;
        
        while(!pq.isEmpty()){
            
            Point p = pq.poll();
            result = matrix[p.row][p.col];
            
            if(++numberCount == k){
                break;
            }
            
            p.col++;
            if(matrix[0].length > p.col)
                pq.add(p);
            
        }
        
        return result;
    }
	
	 public int kthSmallestNSquare(int[][] matrix, int k) {
        
        if(matrix.length == 0 || k <= 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                
                if(pq.size() < k)
                    pq.add(matrix[row][col]);
                else{
                    int temp = pq.peek();
                    if(temp > matrix[row][col]){
                        pq.remove();
                        pq.add(matrix[row][col]);
                    }
                }
            }
        }
        return pq.poll();
    }
}

class Point {
    
    int row;
    int col;
    
    Point(int r , int c){
        row = r;
        col = c;
    }
    
}