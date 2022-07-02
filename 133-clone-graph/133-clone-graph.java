class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        map = new HashMap<>();
        helper(node);
        return map.get(node);
    }
    private void helper(Node node){
        if(map.containsKey(node))return;
        Node n = new Node(node.val);
        map.put(node,n);
        for(Node x:node.neighbors){
            helper(x);
            n.neighbors.add(map.get(x));
        }
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/