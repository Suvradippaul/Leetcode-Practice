class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    void solve(String s, int i, List<String> list, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int index = i; index < s.length(); index++) {
            if (palindrome(s, i, index)) {
                list.add(s.substring(i, index+1));
                solve(s, index+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    
    boolean palindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}