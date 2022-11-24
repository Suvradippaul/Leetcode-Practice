class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (solve(board, word, i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    boolean solve(char[][] board, String word, int i, int j, int n) {
        if (n == word.length()) return true;
        
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != word.charAt(n)) return false;
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        // go left
        if (solve(board, word, i, j-1, n+1)) return true;
        
        // go right
        if (solve(board, word, i, j+1, n+1)) return true;
        
        // go up
        if (solve(board, word, i-1, j, n+1)) return true;
        
        // go down
        if (solve(board, word, i+1, j, n+1)) return true;
        
        board[i][j] = temp;
        
        return false;
    }
}