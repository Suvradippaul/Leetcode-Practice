class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        return solve(arr, k);
    }
    
    boolean solve(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
            else {
				if (i - map.get(sum) >= 2) return true;
			}
            if (sum % k == 0 && i > 0) return true;
			if (sum - arr[0] < k) continue;
			if (findMultiple(map, i, sum, k)) return true;
		}
		
		return false;
	}

	boolean findMultiple(Map<Integer, Integer> map, int i, int currSum, int k) {
		int multiplier = 1;
		while (k * multiplier <= currSum) {
			if (map.containsKey(currSum-k*multiplier)) {
				if (i - map.get(currSum-k*multiplier) >= 2) return true;
			}
			multiplier++;
		}
		return false;
	}
}