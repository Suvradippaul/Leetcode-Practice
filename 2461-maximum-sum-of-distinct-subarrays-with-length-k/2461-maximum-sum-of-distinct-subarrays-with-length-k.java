class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
		int i = 0, j = 0;
		long sum = 0;
		long maxSum = 0;
		
		while (j < arr.length) {
			if (!set.contains(arr[j])) {
				if (j-i+1 < k) {
					set.add(arr[j]);
					sum += arr[j];
				}
				else {
					set.add(arr[j]);
					sum += arr[j];
					maxSum = Math.max(maxSum, sum);
					sum -= arr[i];
					set.remove(arr[i]);
					i++;
				}
			}
			else {
				i = j;
				sum = arr[i];
				set = new HashSet<>();
				set.add(arr[j]);
			}
			j++;
		}
		
		return maxSum;
    }
}