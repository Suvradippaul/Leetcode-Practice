class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int pairs = 0;
        long ans = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            pairs += map.get(nums[j]) - 1;
            while (i < n && pairs >= k) {
                ans += n - j;
                map.put(nums[i], map.get(nums[i])-1);
                pairs -= map.get(nums[i]);
                i++;
            }
            j++;
        }
        
        return ans;
    }
}