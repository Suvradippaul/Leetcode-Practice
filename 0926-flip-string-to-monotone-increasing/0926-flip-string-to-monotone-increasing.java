class Solution {
    public int minFlipsMonoIncr(String s) {
        int count_flip = 0, count_one = 0;
		
		for (char i : s.toCharArray()) {
			if (i == '1')
				count_one++;
			else {
				count_flip++;
				count_flip = Math.min(count_flip, count_one);
			}
		}
        
		return count_flip;
    }
}