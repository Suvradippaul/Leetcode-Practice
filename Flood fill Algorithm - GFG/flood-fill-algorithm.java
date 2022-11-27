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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if (image[sr][sc] == newColor) return image;
        int n = image.length;
        int m = image[0].length;
        
        dfs(image, sr, sc, image[sr][sc], newColor, n, m);
        
        return image;
    }
    
    void dfs(int[][] image, int row, int col, int initColor, int newColor, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != initColor) return;
        
        image[row][col] = newColor;
        
        dfs(image, row-1, col, initColor, newColor, n, m);
        dfs(image, row+1, col, initColor, newColor, n, m);
        dfs(image, row, col-1, initColor, newColor, n, m);
        dfs(image, row, col+1, initColor, newColor, n, m);
    }
}