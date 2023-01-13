class Solution {
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        
        solve(0, adj, s);
        return maxPath;
    }
    
    int maxPath = 0;
    
    int solve(int node, List<List<Integer>> adj, String s) {
        // from this current node, we are calculating what max and second max longest path we can get from neighbour
        int max = 0;
        int secondMax = 0;
        
        for (int neighbour : adj.get(node)) {
            int path = solve(neighbour, adj, s);    // this is the longest path we can get from a neighbour
            if (s.charAt(node) == s.charAt(neighbour)) continue;
            else {
                // updating max and secondMax
                if (path > max) {
                    secondMax = max;
                    max = path;
                }
                else if (path > secondMax) {
                    secondMax = path;
                }
            }
        }
        
        maxPath = Math.max(maxPath, 1 + max + secondMax);    // maxPath = max from any neighbour + secondMax from another neighbour + current node
        return 1 + max;
    }
}