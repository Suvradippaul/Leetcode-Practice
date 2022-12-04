class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long minDiff = Integer.MAX_VALUE;
        int ans = 0;
        
        long sum = 0;
        for(int num : nums) sum += num;
        
        long l = 0; long r = sum;
        for (int i = 0; i < n; i++) {
            l += nums[i];
            r -= nums[i];
            long lAvg = l/(i+1);
            long rAvg = (n-1-i) != 0 ? r/(n-1-i) : r;
            long diff = Math.abs(lAvg - rAvg);
            if (diff == 0) return i;
            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            }
        }
        
        return ans;
    }
}