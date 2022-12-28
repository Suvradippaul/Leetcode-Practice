class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<piles.length;i++){
            queue.offer(piles[i]);
        }
        
        while(k > 0) {
            int num = queue.poll();
            queue.offer((num+1)/2);
            k--;
        }
        
        int sum = 0;
        while(!queue.isEmpty()){
            sum += queue.poll();
        }
        
        return sum;
    }
}