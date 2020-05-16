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
    public ListNode insertionSortList(ListNode head) {
        ListNode preHead = new ListNode(0);
        ListNode prev = preHead;
        
        while(head != null){
            ListNode temp = head.next;
            
            if(prev.val >= head.val)
                prev = preHead;
            
            while(prev.next != null && prev.next.val < head.val){
                prev = prev.next;
            }
            
            head.next = prev.next;
            prev.next = head;
            
            head = temp;
        }
        
        return preHead.next;
    }
}