class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int num : nums) queue.add(num);
        
        long ans = 0;
        while (k-- > 0) {
            int num = queue.poll();
            ans += num;
            if (num%3 == 0) queue.add(num/3);
            else queue.add((num/3) + 1);
        }
        
        return ans;
    }
}