//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        
        for (int i = 0; i < V; i++) {
            if (visited[i] == -1 && !check(i, adj, visited)) return false;
        }
        
        return true;
    }
    
    boolean check(int start, ArrayList<ArrayList<Integer>>adj, int[] visited) {
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