class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        
        int n = strs.length;
        
        int count = 0;
        for (int col = 0; col < len; col++) {
            for (int row = 1; row < n; row++) {
                if (strs[row].charAt(col) < strs[row-1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}