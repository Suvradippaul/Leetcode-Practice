class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
        	if (nums[i] > sum + nums[i]) {
        		sum = nums[i];
        	}
        	else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        
        return max;
    }
}