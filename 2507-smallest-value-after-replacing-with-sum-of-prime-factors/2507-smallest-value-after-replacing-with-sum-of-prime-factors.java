class Solution {
    public int smallestValue(int n) {
        int prev = n;
        while (!isPrime(n)) {
            n = sumOfPrimes(n);
            if (prev == n) break;
            prev = n;
        }
        
        return n;
    }
    
    int sumOfPrimes(int n) {
        int sum = 0;
        int i = 2;
        while (n != 1) {
            while (n%i == 0) {
                n /= i;
                sum += i;
            }
            i++;
        }
        return sum;
    }
    
    boolean isPrime(int n) {
		if (n <= 1 || n%2 == 0 || n%3 == 0 || n%5 == 0 || n%7 == 0) return false;
		for (int i = 2; i <= n/i; i++) {
			if (n%i == 0) return false;
		}
		return true;
	}
}