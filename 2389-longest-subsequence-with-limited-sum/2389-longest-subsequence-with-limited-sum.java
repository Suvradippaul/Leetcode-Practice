// Intuition
// lets say array is        4  5  2  1
// sorted array is          1  2  4  5
// Then prefix sum is       1  3  7  12

// Means - 
// 1 element sum upto to 1
// 2 elements sum upto 3
// 3 elements sum upto 7
// 4 elements sum upto 12

// now we just need to binary search over prefix sum to find how many nums sum less than or equal to a certain target

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        
        Arrays.sort(nums);
        
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int target = queries[i];
            int lo = 0, hi = n-1;
            while (lo <= hi) {
                int mid = (lo+hi) >> 1;
                int sum = nums[mid];
                if (sum == target) {
                    ans[i] = mid+1;
                    break;
                }
                else if (sum < target) {
                    ans[i] = mid + 1;
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        
        return ans;
        
        
    }
}