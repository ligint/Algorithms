class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        for(N = (N - 1) % 14 + 1; N > 0; N--){
            
            int[] resultCells = new int[8];
            
            for(int i = 1; i < 7; i++){
                
                resultCells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            
            cells = resultCells;
        }
        return cells;
    }
}