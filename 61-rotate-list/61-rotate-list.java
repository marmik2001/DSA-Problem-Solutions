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
    public ListNode rotateRight(ListNode head, int k) {
        int len = length(head);
        if(len==0||k%len==0)return head;
        k = k%len;
        ListNode nextHead = head, prev= null;
        for(int i=0;i<len-k;i++){
            prev = nextHead;
            nextHead = nextHead.next;
        }
        if(prev!=null)
            prev.next = null;
        ListNode temp = nextHead;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;
        return nextHead;
    }
    private int length(ListNode root){
        int count = 0;
        ListNode temp = root;
        while(temp!=null){
            count++;
            temp = temp.next; 
        }
        return count;
    }
}