class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    
        int sum = 0;
        for (int pile : piles) {
            queue.add(pile);
            sum += pile;
        }
        
        while (k > 0 && queue.peek() > 0) {
            int num = queue.poll();
            int half = num/2;
            num -= half;
            queue.add(num);
            sum -= half;
            k--;
        }
        
        return sum;
    }
}