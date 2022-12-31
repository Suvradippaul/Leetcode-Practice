class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int startI = 0;
        int startJ = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    break;
                }
            }
        }
        
        int[][] visited = new int[n][m];
        
        return solve(startI, startJ, grid, visited);
    }
    
    int solve(int i, int j, int[][] grid, int[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == -1) return 0;
        
        if (grid[i][j] == 2 && check(visited, i, j, grid)) return 1;
        
        visited[i][j] = 1;
        
        // go down
        int down = solve(i+1, j,  grid, visited);
        
        // go up
        int up = solve(i-1, j, grid, visited);
        
        // go left
        int left = solve(i, j-1, grid, visited);
        
        // go right
        int right = solve(i, j+1, grid, visited);
        
        visited[i][j] = 0;
        
        return up + down + left + right;
    }
    
    boolean check(int[][] visited, int endI, int endJ, int[][] grid) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if ((i == endI && j == endJ) || (grid[i][j] == -1)) continue;
                else if (visited[i][j] != 1) return false;
            }
        }
        
        return true;
    }
}