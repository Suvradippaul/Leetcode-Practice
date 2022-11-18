// Intuition - Ugly numbers = [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] - But how to generate these numbers?
// 1. At every step, take the last ugly number.
// 2. Multiply that number to 2, 3 and 5.
// 3. Add them to a set (in sorted order). You can use TreeSet for this purpose.


class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        
        long num = 1;
        set.add(num);
        
        int count = 0;
        while (count++ < n) {
            num = set.pollFirst();
            set.add(num*2);
            set.add(num*3);
            set.add(num*5);
        }
        
        return (int)num;
    }
}