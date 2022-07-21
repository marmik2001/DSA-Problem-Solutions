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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode x1, TreeNode x2){
        if(x1==null&&x2==null)return true;
        if(x1==null||x2==null)return false;
        if(x1.val!=x2.val)return false;
        return isMirror(x1.left,x2.right)&&isMirror(x1.right,x2.left);
    }
}