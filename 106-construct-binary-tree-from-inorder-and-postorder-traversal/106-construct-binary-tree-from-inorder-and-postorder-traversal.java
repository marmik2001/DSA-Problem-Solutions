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
    int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length-1;
        return helper(inorder, postorder, 0, i);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int il, int ir){
        if(ir<il)return null;
        TreeNode x = new TreeNode(postorder[i--]);
        int index = il;
        for(;index<=ir;index++){
            if(inorder[index]==x.val)
                break;
        }
        x.right = helper(inorder, postorder, index+1, ir);
        x.left = helper(inorder, postorder, il, index-1);
        return x;
    }
}