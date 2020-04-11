class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> results = new ArrayList<>();
        if(matrix.length == 0)
            return results;
        
        int row1 = 0, row2 = matrix.length - 1;
        int col1 = 0, col2 = matrix[0].length - 1;
        
        while(row1 <= row2 && col1 <= col2){
            
            for(int col = col1; col <= col2 ; col++)
                results.add(matrix[row1][col]);
            
            for(int row = row1 + 1; row <= row2 ; row++)
                results.add(matrix[row][col2]);
            
            if(row1 < row2 && col1 < col2){
                for(int col = col2 - 1; col > col1; col--)
                    results.add(matrix[row2][col]);
                for(int row = row2 ; row > row1; row--)
                    results.add(matrix[row][col1]);
            }
            
            row1++;
            row2--;
            col1++;
            col2--;
        }
        return results;
    }
}