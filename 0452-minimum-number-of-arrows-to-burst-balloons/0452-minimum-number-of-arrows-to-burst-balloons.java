class Pair {
    int start;
    int end;
    Pair(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

class Custom_Comparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.start == p2.start) return Integer.compare(p1.end, p2.end);
        return Integer.compare(p1.start, p2.start);
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
            List<Pair> list = new ArrayList<>();
            for (int[] point : points) {
                list.add(new Pair(point[0], point[1]));
            }
            Collections.sort(list, new Custom_Comparator());

            int count = 0;
            int i = 0;
            while (i < list.size()) {
                int end = list.get(i).end;
                i++;
                while (i < list.size() && list.get(i).start <= end) {
                    end = Math.min(list.get(i).end, end);
                    i++;
                }
                count++;
            }

            return count;
    }
}