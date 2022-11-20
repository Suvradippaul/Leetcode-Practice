class Solution {
    public int calculate(String s) {
        return solve(s);
    }
    
    int solve(String s) {
		s = s.trim();
		int n = s.length();
		int i = 0;
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		
		while (i < n) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				num = num * 10 + (ch - '0');
			}
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				update(sign, num, stack);
				num = 0;
				sign = ch;
			}
			i++;
		}
		
		update(sign, num, stack);
		
		return sum(stack);
	}
	
	int sum(Stack<Integer> stack) {
		System.out.println(stack);
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}

	void update(char op, int val, Stack<Integer> stack) {
		if (op == '+') stack.push(val);
		else if (op == '-') stack.push(-val);
		else if (op == '*') stack.push(stack.pop() * val);
		else if (op == '/') stack.push(stack.pop() / val);
	}
}