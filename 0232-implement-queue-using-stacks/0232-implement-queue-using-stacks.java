class MyQueue {
    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        push(x);
        stack.push(temp);
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}