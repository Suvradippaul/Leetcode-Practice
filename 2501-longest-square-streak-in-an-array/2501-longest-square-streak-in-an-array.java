class Solution {
    public int longestSquareStreak(int[] arr) {
        return solve(arr);
    }
    
    int solve(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        
        int max = 1;
        for (int num : set) {
            int n = num;
            int count = 1;
            while (set.contains(n*n)) {
                count += 1;
                n = n*n;
            }
            max = Math.max(max, count);
        }
        
        return max > 1 ? max : -1;
    }
}