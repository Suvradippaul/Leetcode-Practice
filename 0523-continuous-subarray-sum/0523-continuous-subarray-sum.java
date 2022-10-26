class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
            if (!map.containsKey(sum%k)) {
                map.put(sum%k, i);
            }
            else {
                if (i - map.get(sum%k) >= 2) return true;
            }
            if (sum % k == 0 && i > 0) return true;
		}
		
		return false;
    }
}