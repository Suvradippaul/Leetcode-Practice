class Solution {
    public int[] closestPrimes(int left, int right) {
        fillPrimes(right);
        
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        
        int num1 = -1; int num2 = -1;
        int diff = right - left + 2;
        
        int minDiff = right - left + 2;
        for (int i = left; i <= right; i++) {
            if (isPrime[i] && i != 1) {
                if (num1 == -1) {
                    num1 = i;
                }
                else if (num2 == -1) {
                    num2 = i;
                    if (num2 - num1 < diff) {
                        ans[0] = num1;
                        ans[1] = num2;
                        diff = num2-num1;
                    } 
                }
                else {
                    num1 = num2;
                    num2 = i;
                    if (num2 - num1 < diff) {
                        ans[0] = num1;
                        ans[1] = num2;
                        diff = num2 - num1;
                    }
                }
            }
        }

        return ans;
    }
    
    boolean[] isPrime;
	boolean[] visited;
	
	void fillPrimes(int n) {       // n is the range of numbers to find primes
		isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		visited = new boolean[n+1];
		
		for (int i = 2; i <= n/i; i++) {
			if (!visited[i]) {
				int num = i;
				int mul = 2;
				while (num * mul < isPrime.length) {
					int prod = num*mul;
					isPrime[prod] = false;
					visited[prod] = true;
					mul++;
				}
			}
		}
	}
}