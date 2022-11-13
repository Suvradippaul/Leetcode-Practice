class Solution {
    public int minimumOperations(TreeNode root) {
        return solve(root);
    }
    
    int solve(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (node == null)
			return 0;

		queue.add(node);
        int count = 0;
        
		while (!queue.isEmpty()) {
			int size = queue.size();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				TreeNode currNode = queue.poll();
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
				arr[i] = currNode.val;
			}
            count += minSwaps(arr);
		}
		return count;
	}
    
    int minSwaps(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sortedArr = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            sortedArr[i] = arr[i];
        }
        
        Arrays.sort(sortedArr);
        
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedArr[i]) {
                int temp = map.get(sortedArr[i]);
                int temp2 = map.get(arr[i]);
                
                map.put(arr[i], temp);
                map.put(sortedArr[i], temp2);
                arr[temp] = arr[i];
                arr[temp2] = sortedArr[i];
                swaps++;
            }
        }
        
        return swaps;
    }
}