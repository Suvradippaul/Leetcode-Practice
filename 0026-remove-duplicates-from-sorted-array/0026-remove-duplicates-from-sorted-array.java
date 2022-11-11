class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        
        int i = 0;  // fast
        int j = 0;  // slow
        
        while (i < n) {
            if (arr[j] != arr[i]) {
                j++;
                arr[j] = arr[i];
            }
            i++;
        }
        
        return j+1;
    }
}