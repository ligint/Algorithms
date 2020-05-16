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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);
        ListNode smaller = smallerHead , bigger = biggerHead;
        while(head != null){
            if(head.val < x){
                smaller = smaller.next = head;
            } else{
                bigger = bigger.next = head;
            }
            head = head.next;
        }
        
        smaller.next = biggerHead.next;
        bigger.next = null;
        
        return smallerHead.next;
    }
}