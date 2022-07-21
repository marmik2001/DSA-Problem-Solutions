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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j=0;j<inorder.length;j++)
            map.put(inorder[j],j);
        i = inorder.length-1;
        return helper(postorder, 0, i, map);
    }
    private TreeNode helper(int[] postorder, int il, int ir, HashMap<Integer, Integer> map){
        if(ir<il)return null;
        TreeNode x = new TreeNode(postorder[i--]);
        int index = map.get(x.val);
        x.right = helper(postorder, index+1, ir, map);
        x.left = helper(postorder, il, index-1, map);
        return x;
    }
}