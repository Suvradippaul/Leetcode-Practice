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
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    
    int maxSum = Integer.MIN_VALUE;
    int solve(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = Math.max(0, solve(root.left));
        int maxRight = Math.max(0, solve(root.right));
        maxSum = Math.max(maxSum, root.val + maxLeft + maxRight);
        return root.val + Math.max(maxLeft, maxRight);
    }
}