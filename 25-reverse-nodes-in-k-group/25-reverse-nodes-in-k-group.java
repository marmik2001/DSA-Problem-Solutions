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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)return head;
        ListNode currentHead = head, firstHead = head, oldHead = null;
        boolean first = true;
        while(currentHead!=null){
            int i=0;
            ListNode nextHead = currentHead;
            for(;i<k&&nextHead!=null;i++)
                nextHead = nextHead.next;
            if(nextHead==null&&i!=k)break;
            if(first){
                firstHead = reverseList(currentHead,oldHead,k);
                first = false;
            }else
                reverseList(currentHead,oldHead,k);
            oldHead = currentHead;
            currentHead = nextHead;
        }
        if(currentHead!=null)
            oldHead.next = currentHead;
        return firstHead;
    }
    private ListNode reverseList(ListNode head, ListNode back,int k) {  
        ListNode temp = null;
        for(int i=0;i<k;i++){
            ListNode x = head.next;
            head.next = temp;
            temp = head;
            head = x;
        }
        if(back!=null)
            back.next = temp;
        return temp;
    }
}
















