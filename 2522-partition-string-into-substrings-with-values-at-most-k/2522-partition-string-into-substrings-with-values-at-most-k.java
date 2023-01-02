class Solution {
    public int minimumPartition(String s, int k) {
        if (s.length() < 10 && k < 10 && Integer.parseInt(s) <= k) return 1;
		int parts = 0;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			while (right+1 - left < 10 && right < s.length() && Integer.parseInt(s.substring(left, right + 1)) <= k) {
				right++;
			}
			if (left == right) return -1;
			left = right;
			parts++;
		}
		return parts;
    }
}