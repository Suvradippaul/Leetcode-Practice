class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {       
        long ans = 0;
        int sum1 = 0;
		int sum2 = 0;
        int n = nums1.length;
		
		for (int i = 0; i < n; i++) {
			sum1 += nums1[i];
			sum2 += nums2[i];
		}
		
		if (sum1 != sum2) return -1;
		
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] != nums2[i]) { 
                int diff = Math.abs(nums1[i]-nums2[i]);
				if (k == 0 || diff % k != 0) return -1;
				ans += diff/k;
			}
		}
		
		return ans/2;
    }
}