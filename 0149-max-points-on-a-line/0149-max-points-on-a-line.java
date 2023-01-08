class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        
        if (n == 1) return 1;
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<Float, Integer> map = new HashMap<>();
            for (int j = i+1; j < n; j++) {
                float slope = findSlope(points[i], points[j]);
                
                map.put(slope, map.getOrDefault(slope, 0)+1);
                max = Math.max(max, map.get(slope));
            }
        }
        
        return max+1;
    }
    
    float findSlope(int[] a, int[] b) {
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        
        if (x1 == x2) return Float.MAX_VALUE;
        if (y1 == y2) return 0;
        
        return (float)(y2-y1) / (float)(x2-x1);
    }
}