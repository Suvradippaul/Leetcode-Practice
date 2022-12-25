//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    List<Integer> ans;
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        ans = new ArrayList<>();
        int[] visited = new int[V];
		int[] pathVisited = new int[V];
		
		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				dfs(i, adj, visited, pathVisited);
			}
		}
		
		Collections.sort(ans);
		return ans;
    }
    
    // this function returns true if a node is safe. It returns false if there is a cycle present.
	boolean dfs(int i, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
		visited[i] = 1;
		pathVisited[i] = 1;
		
		for (int neighbour : adj.get(i)) {
			if (visited[neighbour] == 0) {
				if (!dfs(neighbour, adj, visited, pathVisited)) return false;     // this path could not reach destination, so it cannot be a safe node.
			}
			else if (visited[neighbour] == 1 && pathVisited[neighbour] == 1) {  // a cycle is present. So cannot be a safe node
				return false;
			}
		}
		
		pathVisited[i] = 0;
		ans.add(i);
		return true;
	}
}
