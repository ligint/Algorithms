class Solution {
    public int[][] diagonalSort(int[][] mat) {
     
        int row = mat.length;
        int col = mat[0].length;
        
        HashMap<Integer, PriorityQueue<Integer>> queue = new HashMap<>();
        
        for(int i = 0; i < row ; i++){
            for(int j = 0; j < col; j++){
                
                queue.putIfAbsent(i - j, new PriorityQueue<>());
                queue.get(i - j).add(mat[i][j]);
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                mat[i][j] = queue.get(i - j).poll();
            }
        }
        
        return mat;
    }
}