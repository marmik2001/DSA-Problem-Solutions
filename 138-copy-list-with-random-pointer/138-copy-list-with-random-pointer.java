
class Solution {
    public Node copyRandomList(Node head) {
        //old,new 
        HashMap<Node,Node> map = new HashMap<>();
        Node tempN = new Node(0);
        Node temp = head;
        while(temp!=null){
            tempN.next = new Node(temp.val);
            tempN = tempN.next;
            map.put(temp,tempN);
            temp = temp.next;   
        }
        temp = head;
        while(temp!=null){
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
