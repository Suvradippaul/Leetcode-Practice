class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        
        // calculating distance from node1 to all nodes
        dfs(node1, edges, dist1, new boolean[n], 0);
        
        // calculating distance from node1 to all nodes
        dfs(node2, edges, dist2, new boolean[n], 0);
        
        int min = n;
        int ansNode = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {        // means this node is reachable from both node1 and node2
                int maxAmongBoth = Math.max(dist1[i], dist2[i]);      // max(dist from node1 to this node, dist from node2 to this node)
                if (maxAmongBoth < min) {
                    min = maxAmongBoth;
                    ansNode = i;
                }
            }
        }
        
        return ansNode;
    }
    
    void dfs(int node, int[] edges, int[] dist, boolean[] visited, int distance) {
        if (node == -1 || visited[node]) return;
        
        visited[node] = true;
        dist[node] = distance;
        dfs(edges[node], edges, dist, visited, distance+1);
    }
}