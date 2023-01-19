// what count be remainder
// 0 to max k-1
// so we are creating freq[i]  ---> number of time rem occurs
// i is rem

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        
        int freq[] = new int[k];
        Arrays.fill(freq, 0);
        freq[0] = 1;
        
        int count = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum % k;
            //if rem is negative, make it positive
            if(rem < 0) rem += k;
            //increase freq of count
            count += freq[rem];
            freq[rem]++;
        }
        
        return count;
    }
}