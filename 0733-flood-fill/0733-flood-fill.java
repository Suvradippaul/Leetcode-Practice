class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {     
        if (image[sr][sc] == newColor) return image;
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    void dfs(int[][] image, int row, int col, int initColor, int newColor) {
        image[row][col] = newColor;
        
        // means upper neighbour has same color
        if (row-1 >= 0 && image[row-1][col] == initColor) {
            dfs(image, row-1, col, initColor, newColor);
        }
        
        // means lower neighbour has same color
        if (row+1 < image.length && image[row+1][col] == initColor) {
            dfs(image, row+1, col, initColor, newColor);
        }
        
        // means left neighbour has same color
        if (col-1 >= 0 && image[row][col-1] == initColor) {
            dfs(image, row, col-1, initColor, newColor);
        }
        
        // means right neighbour has same color
        if (col+1 < image[0].length && image[row][col+1] == initColor) {
            dfs(image, row, col+1, initColor, newColor);
        }
    }
}