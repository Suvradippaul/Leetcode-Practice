class MedianFinder {
    List<Double> list;
    int n;
    
    public MedianFinder() {
        list = new ArrayList<>();
        n = 0;
    }
    
    public void addNum(int number) {
        double num = (double)(number);
        if (n > 0 && num > list.get(n-1)) list.add(num);
        else {
            int pos = findPos(num);
            list.add(pos, num);
        }
        n++;
    }
    
    public double findMedian() {
        if (n % 2 == 0) {
            int mid = n/2;
            return (list.get(mid-1) + list.get(mid))/2;
        }
        else {
            return list.get((n)/2);
        }
    }
    
    int findPos(double target) {
		int lo = 0;
		int hi = n - 1;
		while (lo < hi) {
			int mid = (lo + hi) >> 1;
			
			if (target > list.get(mid)) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		
		return lo;
	}
}