class Solution {
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null){
            TreeNode x = root.left;
            while(x.right!=null)
                x = x.right;
            x.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}