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
    private int min;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        min = Integer.MAX_VALUE;
        helper(root,1);
        return min;
    }
    private void helper(TreeNode x, int height){
        if(x==null)return;
        if(x.left==null&&x.right==null)min = Math.min(min,height);
        helper(x.left,height+1);
        helper(x.right,height+1);
    }
}