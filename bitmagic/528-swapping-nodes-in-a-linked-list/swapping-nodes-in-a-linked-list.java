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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int count=0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        curr = head;
        int len=count-k;
        while(len>0){
            curr = curr.next;
            len--;
        }
        ListNode fcurr = head;
        while(k>1){
            fcurr = fcurr.next;
            k--;
        }
        int rval = curr.val ;
        curr.val = fcurr.val;
        fcurr.val = rval;

        return head;
    }
}