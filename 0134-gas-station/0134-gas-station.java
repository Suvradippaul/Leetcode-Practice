class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        
        int prevSum = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            if (prevSum + gas[i] - cost[i] < 0) {
                startIndex = i+1;
                prevSum = 0;
            }
            else {
                prevSum += gas[i] - cost[i];
            }
        }
        
        return startIndex;
    }
}