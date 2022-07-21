/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1, next = 0;
        while(!queue.isEmpty()){
            Node x = queue.poll();
            cur--;
            if(cur>0)
                x.next = queue.peek();
            if(x.left!=null){
                queue.add(x.left);
                next++;
            }
            if(x.right!=null){
                queue.add(x.right);
                next++;
            }
            if(cur==0){
                cur = next;
                next = 0;
            }
        }
        return root;
    }
}