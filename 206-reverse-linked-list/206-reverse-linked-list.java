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
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        ListNode temp = null;
        while(head.next!=null){
            ListNode x = head.next;
            head.next = temp;
            temp = head;
            head = x;
        }
        head.next = temp;
        return head;
    }
}