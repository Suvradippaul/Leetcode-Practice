class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reachable = 0;
        for (int i = 0; i < n; i++) {
            if (reachable < i) return false;
            if (reachable >= n-1) return true;
            reachable = Math.max(reachable, i+nums[i]);
        }
        
        return false;
    }
}