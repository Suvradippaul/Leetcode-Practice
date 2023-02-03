class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[][] mat = new char[numRows][s.length()];
        for (char[] row : mat) Arrays.fill(row, '#');
        
        int i = 0;
        int row = 0;
        int col = 0;
        boolean down = true;
        boolean diagUp = false;
        
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (down) {
                if (row < numRows) {
                    mat[row][col] = ch;
                    row++;
                }
                if (row == numRows-1) {
                    diagUp = true;
                    down = false;
                }
            }
            else if (diagUp){
                if (row >= 0) {
                    mat[row][col] = ch;
                    row--;
                    col++;
                }
                if (row == 0) {
                    down = true;
                    diagUp = false;
                }
            }
            i++;
        }
        
        StringBuilder ans = new StringBuilder();
        for (i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != '#') {
                    ans.append(mat[i][j]);
                }
            }
        }
        
        return ans.toString();
    }
}