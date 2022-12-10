/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long maxProd = 0;
    public int maxProduct(TreeNode root) {
        int mod = (int)1e9+7;
        long totalSum = getSum(root);
        findMax(root, totalSum);
        return (int)(maxProd%mod);
    }
    
    long getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
    
    long findMax(TreeNode root, long totalSum) {
        if (root == null) return 0;
        
        // sum of subtree at this node 
        long sum = root.val + findMax(root.left, totalSum) + findMax(root.right, totalSum);
        
        // remaining sum
        long remSum = totalSum - sum;
        
        // take max product
        maxProd = Math.max(maxProd, sum*remSum);
        
        return sum;
    }
}