// INTUITION - 
// 1. Touch all the cells that are connected to boundary directly or indirectly. Mark them as visited
// 2. Then for cells with 'O' which are not connected to boundary in any way, turn them into 'X'

// STEPS - 
// 1. BFS on cells that are 'O' and are on boundary. Mark all cells connected to them as visited
// 2. Then for cells with 'O' which are unvisited, turn them into 'X'

class Pair {
	int row;
	int col;

	Pair (int r, int c) {
		this.row = r;
		this.col = c;
	}
}

class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
		
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		for (int j = 0; j < m; j++) {
			if (grid[0][j] == 'O' && !visited[0][j]) {
				queue.add(new Pair(0, j));
				visited[0][j] = true;
			}
			if (grid[n-1][j] == 'O' && !visited[n-1][j]) {
				queue.add(new Pair(n-1, j));
				visited[n-1][j] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (grid[i][0] == 'O' && !visited[i][0]) {
				queue.add(new Pair(i, 0));
				visited[i][0] = true;
			}
			if (grid[i][m-1] == 'O' && !visited[i][m-1]) {
				queue.add(new Pair(i, m-1));
				visited[i][m-1] = true;
			}
		}
		
		int[] dRow = {-1, 0, +1, 0};
		int[] dCol = {0, +1, 0, -1};
		
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int r = pair.row;
			int c = pair.col;
			
			for (int i = 0; i < 4; i++) {
				int row = r + dRow[i];
				int col = c + dCol[i];
				
				if (isValid(row, col, n, m) && grid[row][col] == 'O' && !visited[row][col]) {
				    queue.add(new Pair(row, col));
					visited[row][col] = true;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'O' && !visited[i][j]) {
				    grid[i][j] = 'X';
				}
			}
		}
        
    }
    
    boolean isValid(int row, int col, int n, int m) {
		if (row >= 0 && row < n && col >= 0 && col < m) return true;
		return false;
	}
}