class Solution {
    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] ans = new int[cols];
        
        for (int col = 0; col < cols; col++) {
            int colCopy = col;         // make a copy of col
            boolean canReach = true;
            
            int row = 0;
            while (row < rows && col < cols) {
                if (col < cols-1 && grid[row][col] == 1 && grid[row][col+1] == 1) {
                    row++;
                    col++;
                }
                else if (col > 0 && grid[row][col] == -1 && grid[row][col-1] == -1) {
                    row++;
                    col--;
                }
                else {
                    canReach = false;
                    break;
                }
            }
            if (canReach) {
                ans[colCopy] = col;        
            }
            else {
                ans[colCopy] = -1;
            }
            
            col = colCopy;           // re-assign col to original value
        }
        
        return ans;
    }
}