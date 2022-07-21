class BSTIterator {
    Stack<TreeNode> stack; 
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return stack.size()>0;
    }
    private void pushAll(TreeNode x){
        while(x!=null){
            stack.add(x);
            x=x.left;
        }
    }
}