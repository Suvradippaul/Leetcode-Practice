class Pair {
    int row;
    int col;
    
    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}


// In this problem, you can use an array or you can modify the input array itself to mark cells as visited
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    bfs(grid, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '1';
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            row = p.row;
            col = p.col;
            
            if (row-1 >= 0 && grid[row-1][col] == '1') {
                queue.add(new Pair(row-1, col));
                grid[row-1][col] = '0';
            }
            if (row+1 < grid.length && grid[row+1][col] == '1') {
                queue.add(new Pair(row+1, col));
                grid[row+1][col] = '0';
            }
            if (col-1 >= 0 && grid[row][col-1] == '1') {
                queue.add(new Pair(row, col-1));
                grid[row][col-1] = '0';
            }
            if (col+1 < grid[0].length && grid[row][col+1] == '1') {
                queue.add(new Pair(row, col+1));
                grid[row][col+1] = '0';
            }
        }
    }
}