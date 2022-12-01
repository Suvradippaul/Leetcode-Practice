class Triplet {
    int row;
    int col;
    int time;

    Triplet(int r, int c, int t) {
        this.row = r;
        this.col = c;
        this.time = t;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        
        ArrayDeque<Triplet> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    queue.add(new Triplet(i, j, 0));
                    visited[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            int r = triplet.row;
            int c = triplet.col;
            int t = triplet.time;
            
            if (r - 1 >= 0 && grid[r - 1][c] == 1 && !visited[r-1][c]) {
				queue.add(new Triplet(r - 1, c, t + 1));
				ans[r-1][c] = t+1;
                visited[r-1][c] = true;
			}
			if (r + 1 < n && grid[r + 1][c] == 1 && !visited[r+1][c]) {
				queue.add(new Triplet(r + 1, c, t + 1));
				ans[r+1][c] = t+1;
                visited[r+1][c] = true;
			}
			if (c - 1 >= 0 && grid[r][c - 1] == 1 && !visited[r][c-1]) {
				queue.add(new Triplet(r, c - 1, t + 1));
				ans[r][c-1] = t+1;
                visited[r][c-1] = true;
			}
			if (c + 1 < m && grid[r][c + 1] == 1 && !visited[r][c+1]) {
				queue.add(new Triplet(r, c + 1, t + 1));
				ans[r][c+1] = t+1;
                visited[r][c+1] = true;
			}
        }
        
        return ans;
        
    }
    
    
}