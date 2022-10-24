class Solution {
    public int maxLength(List<String> list) {
        return solve(list, 0, "");
    }
    
    int solve(List<String> arr, int i, String s) {
		if (i == arr.size()) {
			return 0;
		}
		
		int pick = 0;
		if (valid(s+arr.get(i))) {
			pick = arr.get(i).length() + solve(arr, i+1, s+arr.get(i));
		}
		int notPick = solve(arr, i+1, s);
		
		return Math.max(pick, notPick);
	}

	boolean valid(String s) {
	    int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            int val = ch - 'a';
            freq[val]++;
            if (freq[val] > 1) return false;
        }
        return true;
	}
}