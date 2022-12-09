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
    public int maxAncestorDiff(TreeNode root) {
        return solve(root, 100001, -1, 0);
    }
    
    int solve(TreeNode root, int lo, int hi, int maxDiff) {
        if (root == null) return maxDiff;
        lo = Math.min(lo, root.val);
        hi = Math.max(hi, root.val);
        int diff = Math.abs(lo-hi);
        if (diff > maxDiff) maxDiff = diff;
        
        return Math.max(solve(root.left, lo, hi, maxDiff), solve(root.right, lo, hi, maxDiff));
    }
}