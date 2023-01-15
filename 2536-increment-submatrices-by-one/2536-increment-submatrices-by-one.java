class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        
        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            
            for (int row = row1; row <= row2; row++) {
                for (int col = col1; col <= col2; col++) {
                     mat[row][col]++;
                }
            }
        }
                  
        return mat;
    }
}