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
    public int getDecimalValue(ListNode head) {
        int Sum =0;
        ListNode curr = head;
        while(curr!= null){
           Sum *= 2;
           Sum += curr.val;
           curr = curr.next;
        }
        return Sum;
    }
}