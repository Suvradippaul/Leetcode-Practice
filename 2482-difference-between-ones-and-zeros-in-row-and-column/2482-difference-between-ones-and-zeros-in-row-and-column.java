class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
		int m = grid[0].length;

		int[] oneRows = new int[n];
        int[] oneCols = new int[m];
        
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
                    oneRows[i] += 1;
                    oneCols[j] += 1;
                }		
			}
		}
        
		int[][] ans = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans[i][j] = oneRows[i] + oneCols[j] - (n - oneRows[i]) - (m - oneCols[j]);
			}
		}
		return ans;
    }
}