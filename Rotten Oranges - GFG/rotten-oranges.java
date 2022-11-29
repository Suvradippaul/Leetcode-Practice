//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


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
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        ArrayDeque<Triplet> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Triplet(i, j, 0));
                }
            }
        }
        
        int maxTime = 0;
        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            int r = triplet.row;
            int c = triplet.col;
            int t = triplet.time;
            
            maxTime = Math.max(maxTime, t);
            
            if (r-1 >= 0 && grid[r-1][c] == 1) {
                queue.add(new Triplet(r-1, c, t+1));
                grid[r-1][c] = 2;
            }
            if (r+1 < n && grid[r+1][c] == 1) {
                queue.add(new Triplet(r+1, c, t+1));
                grid[r+1][c] = 2;
            }
            if (c-1 >= 0 && grid[r][c-1] == 1) {
                queue.add(new Triplet(r, c-1, t+1));
                grid[r][c-1] = 2;
            }
            if (c+1 < m && grid[r][c+1] == 1) {
                queue.add(new Triplet(r, c+1, t+1));
                grid[r][c+1] = 2;
            }
        }
        
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
            }
        }
        
        return maxTime;
    }
}