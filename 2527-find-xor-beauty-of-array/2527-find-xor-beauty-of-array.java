// Intuition - 
// See at example 1. All the effective values are cancelled with each other. Only the values themselves remain at last. So return XOR of all the values of array.  

class Solution {
    public int xorBeauty(int[] nums) {
        int xor = 0;
        for (int n : nums) xor ^= n;
        return xor;
    }
}