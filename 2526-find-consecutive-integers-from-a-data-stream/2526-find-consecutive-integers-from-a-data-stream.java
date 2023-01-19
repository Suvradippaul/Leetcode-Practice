class DataStream {
    Queue<Integer> queue;
    Map<Integer, Integer> map;
    int value;
    int k;
    
    public DataStream(int value, int k) {
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        queue.add(num);
        map.put(num, map.getOrDefault(num, 0) + 1);
        
        if (queue.size() < k) return false;
        
        while (queue.size() > k) {
            int poll = queue.poll();
            map.put(poll, map.get(poll)-1);
        }
        
        return map.getOrDefault(value, 0) == k;
    }
}