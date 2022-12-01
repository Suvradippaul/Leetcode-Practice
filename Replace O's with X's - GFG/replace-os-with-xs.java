//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair {
	int row;
	int col;

	Pair (int r, int c) {
		this.row = r;
		this.col = c;
	}
}

class Solution{
    static char[][] fill(int n, int m, char grid[][]) {
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
		
		char[][] ans = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'O' && !visited[i][j]) {
				    ans[i][j] = 'X';
				}
				else ans[i][j] = grid[i][j];
			}
		}
		
		return ans;
    }
    
    static boolean isValid(int row, int col, int n, int m) {
		if (row >= 0 && row < n && col >= 0 && col < m) return true;
		return false;
	}
}