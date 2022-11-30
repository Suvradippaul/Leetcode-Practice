//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair {
    int node;
    int parent;
    Pair(int n, int p) {
        this.node = n;
        this.parent = p;
    }
}

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        return solve(V, adj);
    }
    
    boolean solve(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                // if (detect(i, adj, visited)) return true;
                if (dfs(adj, i, -1, visited)) return true;
            }
        }
        
        return false;
    }
    
    // boolean detect(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
    //     visited[src] = 1;
    //     ArrayDeque<Pair> queue = new ArrayDeque<>();
    //     queue.add(new Pair(src, -1));
        
    //     while (!queue.isEmpty()) {
    //         Pair p = queue.poll();
    //         int node = p.node;
    //         int parent = p.parent;
            
    //         for (int adjNode : adj.get(node)) {
    //             if (visited[adjNode] != 1) {
    //                 visited[adjNode] = 1;
    //                 queue.add(new Pair(adjNode, node));
    //             }
    //             else if (parent != adjNode) return true;
    //         }
    //     }
        
    //     return false;
    // }
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, int[] visited) {
		if (visited[node] == 1) return true;
		
		visited[node] = 1;
		
		for (int adjNode : adj.get(node)) {
			if (adjNode != parent) {
				if (dfs(adj, adjNode, node, visited)) return true;
			}
		}
		
		return false;
	}
}