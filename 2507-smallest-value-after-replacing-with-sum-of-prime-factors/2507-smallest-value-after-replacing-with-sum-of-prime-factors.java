class Solution {
    boolean[] isPrime;
	boolean[] vis;
	void fill(int n) {
		isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		vis = new boolean[n+1];
		
		for (int i = 2; i < isPrime.length; i++) {
			if (!vis[i]) {
				int num = i;
				int mul = 2;
				while (num * mul < isPrime.length) {
					int prod = num*mul;
					isPrime[prod] = false;
					vis[prod] = true;
					mul++;
				}
			}
		}
	}
    
    public int smallestValue(int n) {
        fill(n);
        
        int prev = n;
        while (!isPrime[n]) {
            n = sum(n);
            if (prev == n) break;
            prev = n;
        }
        
        return n;
    }
    
    int sum(int n) {
        int add = 0;
        int i = 2;
        while (n != 1 && i <= n) {
            if (n%i == 0) {
                n /= i;
                add += i;
            }
            else {
                i++;
            }
        }
        return add;
    }
}