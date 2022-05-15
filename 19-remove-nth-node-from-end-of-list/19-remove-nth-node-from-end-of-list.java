/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode back = head, front = head;
        while(n-->0)
            front = front.next;
        if(front==null)return head.next;
        while(front.next!=null){
            back = back.next;
            front = front.next;
        }
        back.next = back.next.next;
        return head;
    }
}