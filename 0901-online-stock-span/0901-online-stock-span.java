class Pair {
    int price;
    int index;
    Pair (int p, int i) {
        this.price = p;
        this.index = i;
    }
}

class StockSpanner {
    int i;
    Stack<Pair> stack;
    
    public StockSpanner() {
        stack = new Stack();
        i = 1;
    }
    
    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new Pair(price, i++));
            return 1;
        }
        
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        
        int ans; 
        if (stack.isEmpty()) ans = i;
        else ans = i - stack.peek().index;
        
        stack.push(new Pair(price, i++));
        
        return ans;
    }
}