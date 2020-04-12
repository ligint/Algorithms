class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if(numRows == 0)
            return results;
        
        
        results.add(new ArrayList<>());
        results.get(0).add(1);
        
        for(int num = 1; num < numRows; num++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = results.get(num - 1);
            
            row.add(1);
            
            for(int j = 1; j < num; j++){
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            row.add(1);
            results.add(row);
        }
        
        return results;
    }
    
}