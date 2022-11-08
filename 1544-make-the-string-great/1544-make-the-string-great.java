class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(ch);
        	else if ((char)(stack.peek()-32) == ch || (char)stack.peek()+32 == ch) {
        		stack.pop();
        	}
        	else {
        		stack.push(ch);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}