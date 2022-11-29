class RandomizedSet {
    List<Integer> list;
    Set<Integer> set;
    Random rand;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        set = new HashSet<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        int index = list.indexOf(val);
        list.remove(index);
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int n = list.size();
        int r = rand.nextInt(n);
        return list.get(r);
    }
}