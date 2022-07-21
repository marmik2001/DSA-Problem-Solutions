class Solution {
    private int i,n;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        n=preorder.length; 
        return helper(preorder, inorder, 0, n-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int pl, int pr){
        if(i==n||pr<pl)
            return null;
        int x=pl;
        for(;x<=pr;x++){
            if(inorder[x]==preorder[i])
                break;
        }
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = helper(preorder, inorder, pl,x-1);
        node.right = helper(preorder, inorder, x+1, pr);
        return node;
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