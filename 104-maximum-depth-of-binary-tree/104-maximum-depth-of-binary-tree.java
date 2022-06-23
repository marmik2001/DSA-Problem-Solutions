class Solution {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    private int depth(TreeNode x){
        if(x==null)return 0;
        return 1+Math.max(depth(x.left),depth(x.right));
    }
}
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