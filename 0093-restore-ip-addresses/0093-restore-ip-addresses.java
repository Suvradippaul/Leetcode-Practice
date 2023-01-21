class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, 0, 0, new StringBuilder(), ans);
        return ans;
    }
    
    void solve(String s, int i, int parts, StringBuilder str, List<String> ans) {
        if (parts > 4 || i > s.length()) return;
        if (i == s.length()) {
        	if (parts == 4) ans.add(str.substring(0, str.length()-1).toString());
        	return;
        }
        
        for (int index = i; index < i+3 && index < s.length(); index++) {
            if (valid(s, i, index)) {
                solve(s, index+1, parts+1, new StringBuilder(str).append(s.substring(i, index+1) + "."), ans);
            }
        }
    }

	boolean valid(String s, int start, int index) {	
		int value = Integer.parseInt(s.substring(start, index+1));
		if (value > 255) return false;
		if (index-start == 2 && value < 100) return false;
		if (index-start == 1 && value < 10) return false;
		
		return true;
	}
}