class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> factors = new HashSet<>();
        
        int div;
        for (int n : nums) {
            div = 2;
            while (n > 1) {
                while (n % div == 0) {
                    factors.add(div);
                    n /= div;
                }
                div++;
            }
        }       
        
        return factors.size();
    }
}