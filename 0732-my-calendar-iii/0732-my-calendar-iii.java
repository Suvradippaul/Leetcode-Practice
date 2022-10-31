class MyCalendarThree {
    Map<Integer, Integer> map;
    
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int sum = 0; int maxIntersections = 0;
        for (int value : map.values()) {
            sum += value;
            maxIntersections = Math.max(sum, maxIntersections);
        }
        
        return maxIntersections;
    }
}