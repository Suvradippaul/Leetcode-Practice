class Triplet {
    int row;
    int col;
    int time;
    Triplet (int r, int c, int t) {
        this.row = r;
        this.col = c;
        this.time = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        ArrayDeque<Triplet> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (grid[i][j] == 2 && visited[i][j] != 2) {
        			queue.add(new Triplet(i, j, 0));
                    visited[i][j] = 2;
        		}
        	}
        }
        
        int maxTime = 0;
		while (!queue.isEmpty()) {
			Triplet t = queue.poll();
			int r = t.row;
			int c = t.col;
			int time = t.time;
			
			maxTime = Math.max(maxTime, time);
			
			if (r-1 >= 0 && grid[r-1][c] == 1 && visited[r-1][c] != 2) {
				visited[r-1][c] = 2;
				queue.add(new Triplet(r-1, c, time+1));
			}
			if (r+1 < grid.length && grid[r+1][c] == 1 && visited[r+1][c] != 2) {
				visited[r+1][c] = 2;
				queue.add(new Triplet(r+1, c, time+1));
			}
			if (c-1 >= 0 && grid[r][c-1] == 1 && visited[r][c-1] != 2) {
				visited[r][c-1] = 2;
				queue.add(new Triplet(r, c-1, time+1));
			}
			if (c+1 < grid[0].length && grid[r][c+1] == 1 && visited[r][c+1] != 2) {
				visited[r][c+1] = 2;
				queue.add(new Triplet(r, c+1, time+1));
			}
		}
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 2) return -1;
            }
        }
        
        return maxTime;
    }
}