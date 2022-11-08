class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len==0) sb.append(ch);
        	else if ((char)(sb.charAt(len-1)-32) == ch || (char)sb.charAt(len-1)+32 == ch) {
        		sb.deleteCharAt(len-1);
        	}
        	else {
        		sb.append(ch);
        	}
        }
        
        return sb.toString();
    }
}