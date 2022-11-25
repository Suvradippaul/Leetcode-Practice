class Solution {
    public int sumSubarrayMins(int[] arr) {        
        return solve(arr);
    }
    
    int[] nextSmaller(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = n-1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				ans[i] = -1;
			}
			else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		
		return ans;
	}
	
	int[] prevSmaller(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			
			if (stack.isEmpty()) {
				ans[i] = -1;
			}
			else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		
		return ans;
	}
	
	int solve(int[] arr) {
		int n = arr.length;
		int mod = (int)(1e9+7);
		int[] prevSmaller = prevSmaller(arr);
		int[] nextSmaller = nextSmaller(arr);
		
		long ans = 0;
		
		for (int i = 0; i < n; i++) {
			int left = prevSmaller[i];
			int right = nextSmaller[i] != -1 ? nextSmaller[i] : n;
			
			long mul = (1L * arr[i] * ((i-left) * (right-i)) % mod) % mod;
			ans = (ans + mul) % mod;
		}
		
		return (int)ans;
	}
}