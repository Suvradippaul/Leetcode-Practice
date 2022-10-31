class Solution {
    public boolean isToeplitzMatrix(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        if (rows < 2) return true;
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (arr[row][col] != arr[row-1][col-1]) return false;
            }
        }
        
        return true;
    }
}