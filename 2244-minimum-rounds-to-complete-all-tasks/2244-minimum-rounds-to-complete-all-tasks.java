class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        
        int rounds = 0;
        for (var entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freq == 1) return -1;
            if (freq % 3 == 0) rounds += freq/3;
            else rounds += freq/3 + 1;
        }
        
        return rounds;
    }
}