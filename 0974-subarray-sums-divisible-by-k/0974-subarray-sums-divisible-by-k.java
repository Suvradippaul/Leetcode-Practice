class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int n : nums) {
            sum += n;
            int tempSum = sum%k;
            if (tempSum < 0) tempSum += k;
            if (map.containsKey(tempSum)) {
                ans += map.get(tempSum);
            }
            map.put(tempSum,map.getOrDefault(tempSum,0) + 1);
        }
        
        return ans;
    }
}