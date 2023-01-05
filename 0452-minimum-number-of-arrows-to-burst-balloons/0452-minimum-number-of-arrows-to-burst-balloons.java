class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
		int count = 1;
		
		int end = points[0][1];
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] > end) {
				end = points[i][1];
				count++;
			}
		}
		
		return count;
    }
}