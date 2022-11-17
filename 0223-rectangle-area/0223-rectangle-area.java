class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sq1 = (ax2-ax1) * (ay2-ay1);
        int sq2 = (bx2-bx1) * (by2-by1);
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        
        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right-left) * (top-bottom);
        }
        
        return sq1 + sq2 - overlap;
    }
}