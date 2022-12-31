// INTUITION - 
// 1. Person A dislikes Person B.
// 2. This means, it does not matter if B dislikes A or not. A and B cannot be in same group.
// 3. Therefore, we can consider that B also dislikes A.
// 4. Hence, we can create an undirected graph of dislikes of A and B.
// 5. Now we just need to check - Can we divide every alternate person to a different group.
// 6. Means person A belongs to group 1. Then all neighbours cannot belong to group 1, but all of them can belong to group 2.

// Note : This question uses 1-based indexing.
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) adj.add(new ArrayList<>());
        
        for (int[] dislike : dislikes) {
            int person1 = dislike[0];
            int person2 = dislike[1];
            
            adj.get(person1).add(person2);
            adj.get(person2).add(person1);
        }
        
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1 && !check(i, adj, visited)) return false;
        }
        
        return true;
    }
    
    boolean check(int start, List<List<Integer>>adj, int[] visited) {
        visited[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == -1) {
                    visited[adjNode] = (visited[node] == 1) ? 0 : 1;
                    queue.add(adjNode);
                }
                else if (visited[node] == visited[adjNode]) return false;
            }
        }
        
        return true;
    }
}