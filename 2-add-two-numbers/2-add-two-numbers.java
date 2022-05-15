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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(), prev = null;
        ListNode temp = head;
        while (l1 != null & l2 != null) {
            temp.val = (carry + l1.val + l2.val) % 10;
            carry = (carry + l1.val + l2.val) / 10;
            temp.next = new ListNode();
            prev = temp;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null){
            while (carry != 0 && l1 != null) {
                temp.val = (carry + l1.val) % 10;
                carry = (carry + l1.val) / 10;
                temp.next = new ListNode();
                prev = temp;
                temp = temp.next;
                l1 = l1.next;
            }
            if(l1!=null){
                prev.next = l1;
                return head;
            }
        }
        if (l2 != null){
            while (carry != 0 && l2 != null) {
                temp.val = (carry + l2.val) % 10;
                carry = (carry + l2.val) / 10;
                temp.next = new ListNode();
                prev = temp;
                temp = temp.next;
                l2 = l2.next;
            }
            if(l2!=null){
                prev.next = l2;
                return head;
            }
        }
        if (carry != 0) {
            temp.val = carry;
            return head;
        }
        prev.next = null;
        return head;
    }
    
}










