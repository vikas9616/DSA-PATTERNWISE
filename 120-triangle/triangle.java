class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        
        for (int row = rows - 2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            List<Integer> nextRow = triangle.get(row + 1);
            
            for (int col = 0; col < currentRow.size(); col++) {
                int minPath = Math.min(nextRow.get(col), nextRow.get(col + 1));
                currentRow.set(col, currentRow.get(col) + minPath);
            }
        }
        
        return triangle.get(0).get(0);
    }
}