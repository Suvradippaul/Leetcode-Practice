class Solution {
    public String reverseWords(String s) {
        s = s.trim();  
        List<String> arr = new ArrayList<>();
        
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (s.charAt(i) == ' ') {
                    i++;
                }
                arr.add(word.toString());
                word = new StringBuilder();
                i--;
            }
            else {
                word.append(s.charAt(i));
            }
        }
        
        arr.add(word.toString());
		Collections.reverse(arr);
		String ans = String.join(" ", arr);
		return ans;
    }
}