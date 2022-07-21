/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(q.val<p.val)return lowestCommonAncestor(root, q, p);
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==p||root==q)return root;
        if(root.val<q.val&&root.val>p.val)return root;
        if(root.val>q.val)
            return helper(root.left, p, q);
        else 
            return helper(root.right, p, q);
    }
}