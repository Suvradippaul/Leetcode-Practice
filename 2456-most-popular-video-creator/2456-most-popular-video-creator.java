class Solution {
    class Pair {
        String id;
        int views;
        Pair(String i, int v) {
            this.id = i;
            this.views = v;
        }
    }
    
    class Custom_comparator implements Comparator<Pair>{

        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.views == p2.views) return p1.id.compareTo(p2.id);
            return p2.views-p1.views;
        }
    }
    
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> viewsMap = new HashMap<>();    // [creator, total_views]
        Map<String, List<Pair>> map = new HashMap<>();      // [creator, [(id, view)]]
        
        int n = ids.length;
        for (int i = 0; i < n; i++) {
            String creator = creators[i];
            viewsMap.put(creator, viewsMap.getOrDefault(creator, 0) + views[i]);
            
            if (!map.containsKey(creator)) {
                map.put(creator, new ArrayList<Pair>());
            }
            map.get(creator).add(new Pair(ids[i], views[i]));
        }
        
        int maxViews = (Collections.max(viewsMap.values()));
        List<String> popularCreators = new ArrayList<>();
        for (var entry : viewsMap.entrySet()) {
            if (entry.getValue()==maxViews) {
                popularCreators.add(entry.getKey());
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (String creator : popularCreators) {
            List<Pair> list = map.get(creator);
            Collections.sort(list, new Custom_comparator());
            List<String> ansList = new ArrayList<>();
            ansList.add(creator);
            ansList.add(list.get(0).id);
            ans.add(ansList);
        }
        
        return ans;
    }
}