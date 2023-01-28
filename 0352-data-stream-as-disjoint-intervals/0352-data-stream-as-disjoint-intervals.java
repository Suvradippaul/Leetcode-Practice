class SummaryRanges {
    private Set<Integer> values;

    public SummaryRanges() {
        values = new TreeSet<>();
    }
    
    public void addNum(int value) {
       values.add(value);
    }
    
    public int[][] getIntervals() {
        if (values.isEmpty()) {
            return new int[0][2];
        }
        
        List<int[]> intervals = new ArrayList<>();
        int left = -1;
        int right = -1;
        for (Integer value : values) {
            if (left < 0) {        // setting the values of left and right to lowest number available.
                left = right = value;
            }
            else if (value == right + 1) {  // if we can increase the end of our current interval, do that
                right = value;
            }
            else {             // can no longer extend this interval, add it to ans. and reset left and right
                intervals.add(new int[] {left, right});
                left = right = value;
            } 
        }
        intervals.add(new int[] {left, right});
        return intervals.toArray(new int[0][]); 
    }
}