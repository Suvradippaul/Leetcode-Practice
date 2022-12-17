class Solution {
    public int evalRPN(String[] tokens) {
        return solve(tokens);
    }
    
    int solve(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String s : tokens) {
            if (s.length() == 1 && !Character.isDigit(s.charAt(0))) {  // symbol
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                char symbol = s.charAt(0);
                int result = operation(operand1, operand2, symbol);
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
    
    int operation(int a, int b, char operator) {
        if (operator == '+') return a+b;
        if (operator == '-') return a-b;
        if (operator == '*') return a*b;
        return a/b;
    }
}