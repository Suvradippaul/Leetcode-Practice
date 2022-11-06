class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
		int i = 0, j = 0;
		long sum = 0;
		long maxSum = 0;
		
		while (j < arr.length) {
			if (j-i+1 < k) {         // window is less than K
				if (!set.contains(arr[j])) {
					set.add(arr[j]);
					sum += arr[j];
				}
				else {
					i = j;
					sum = arr[i];
					set.clear();
					set.add(arr[j]);
				}
			}
			else if (j-i+1 == k && !set.contains(arr[j])){                 
				if (!set.contains(arr[j])) {
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
				set.clear();
				set.add(arr[j]);
			}
			j++;
		}
		
		return maxSum;
    }
}