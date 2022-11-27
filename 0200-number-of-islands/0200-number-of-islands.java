class Pair {
    int row;
    int col;
    
    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && visited[row][col] == 0) {
                    bfs(grid, row, col, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void bfs(char[][] grid, int row, int col, int[][] visited) {
        visited[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            row = p.row;
            col = p.col;
            
            if (row-1 >= 0 && grid[row-1][col] == '1' && visited[row-1][col] == 0) {
                queue.add(new Pair(row-1, col));
                visited[row-1][col] = 1;
            }
            if (row+1 < grid.length && grid[row+1][col] == '1' && visited[row+1][col] == 0) {
                queue.add(new Pair(row+1, col));
                visited[row+1][col] = 1;
            }
            if (col-1 >= 0 && grid[row][col-1] == '1' && visited[row][col-1] == 0) {
                queue.add(new Pair(row, col-1));
                visited[row][col-1] = 1;
            }
            if (col+1 < grid[0].length && grid[row][col+1] == '1' && visited[row][col+1] == 0) {
                queue.add(new Pair(row, col+1));
                visited[row][col+1] = 1;
            }
        }
    }
}