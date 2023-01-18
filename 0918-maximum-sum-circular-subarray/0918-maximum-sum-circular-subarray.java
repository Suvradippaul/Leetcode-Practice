class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int nonCircularMaxSum = maxSubarraySum(nums);
        int circularMaxSum = totalSum(nums) - minSubarraySum(nums);
        
        if (circularMaxSum == 0) return nonCircularMaxSum;
        
        return Math.max(nonCircularMaxSum, circularMaxSum);
    }
    
    int totalSum(int[] nums) {
		int sum = 0;
		for (int n : nums) sum += n;
		return sum;
	}

	int maxSubarraySum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > sum + nums[i]) {
            	sum = nums[i];
            }
            else {
            	sum += nums[i];
            }
            
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
	
	int minSubarraySum(int[] nums) {
		int minSum = Integer.MAX_VALUE;
		int sum = 0;
		
		for (int n : nums) {
			if (n < sum + n) {
				sum = n;
			}
			else {
				sum += n;
			}
			
			minSum = Math.min(minSum, sum);
		}
		
		return minSum;
	}
}