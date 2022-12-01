class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

// This problem is exactly same as - '130. Surrounded Regions' problem
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		for (int j = 0; j < m; j++) {
			if (grid[0][j] == 1) {
				queue.add(new Pair(0, j));
                grid[0][j] = 9;               // 9 is a dummy number, just to mark it as visited
			}
			if (grid[n - 1][j] == 1) {
				queue.add(new Pair(n - 1, j));
                grid[n-1][j] = 9;
			}
		}
		for (int i = 0; i < n; i++) {
			if (grid[i][0] == 1) {
				queue.add(new Pair(i, 0));
                grid[i][0] = 9;
			}
			if (grid[i][m - 1] == 1) {
				queue.add(new Pair(i, m - 1));
                grid[i][m-1] = 9;
			}
		}

		int[] dRow = { -1, 0, +1, 0 };
		int[] dCol = { 0, +1, 0, -1 };

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int r = pair.row;
			int c = pair.col;

			for (int i = 0; i < 4; i++) {
				int row = r + dRow[i];
				int col = c + dCol[i];

				if (isValid(row, col, n, m) && grid[row][col] == 1) {
					queue.add(new Pair(row, col));
                    grid[row][col] = 9;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					ans++;
				}
			}
		}

		return ans;
    }
    
    boolean isValid(int row, int col, int n, int m) {
		if (row >= 0 && row < n && col >= 0 && col < m) return true;
		return false;
	}
}