class Solution {
    List<Integer> nodes = new ArrayList<>(); 
    void traverse(TreeNode root) {
        if (root == null) return;
        
        traverse(root.left);
        nodes.add(root.val);
        traverse(root.right);
    }
    
    List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        traverse(root);
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nodes.size();
        Collections.sort(nodes);
        
        for (int q : queries) {            
            if (q == nodes.get(0) || q == nodes.get(n-1)) {
            	ans.add(Arrays.asList(q, q));
            }
            else if (q < nodes.get(0)) {
            	ans.add(Arrays.asList(-1, nodes.get(0)));
            }
            else if (q > nodes.get(n-1)) {
            	ans.add(Arrays.asList(nodes.get(n-1), -1));
            }
            else {
            	int lo = 0;
            	int hi = n-1;
            	boolean found = false;
            	while (lo < hi) {
            		int m = (lo+hi) >> 1;
            		int mid = nodes.get(m);
            		if (q == mid) {
            			found = true;
            			ans.add(Arrays.asList(q, q));
            			break;
            		}
            		else if (q > mid) {
            			lo = m + 1;
            		}
            		else {
            			hi = m;
            		}
            	}
            	
            	if (!found) {
            		ans.add(Arrays.asList(nodes.get(lo-1), nodes.get(lo)));
            	}
            }
        }
        
        return ans;
    } 
}