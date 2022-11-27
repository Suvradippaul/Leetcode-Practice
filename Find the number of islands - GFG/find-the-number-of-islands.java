//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair {
    int row;
    int col;
    
    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
       int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // void bfs(char[][] grid, int row, int col) {
    //     grid[row][col] = '1';
        
    //     Queue<Pair> queue = new LinkedList<>();
    //     queue.add(new Pair(row, col));
        
    //     while (!queue.isEmpty()) {
    //         Pair p = queue.poll();
    //         row = p.row;
    //         col = p.col;
            
    //         for (int dRow = -1; dRow <= 1; dRow++) {
    //             for (int dCol = -1; dCol <= 1; dCol++) {
    //                 int nRow = row + dRow;
    //                 int nCol = col + dCol;
    //                 if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == '1') {
    //                     grid[nRow][nCol] = '0';
    //                     queue.add(new Pair(nRow, nCol));
    //                 }
    //             }
    //         }
    //     }
    // }
    
    void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        
        grid[row][col] = '0';
        
        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                int nRow = row + dRow;
                int nCol = col + dCol;
                dfs(grid, nRow, nCol);
            }
        }
    }
}