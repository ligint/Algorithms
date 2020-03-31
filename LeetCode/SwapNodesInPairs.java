/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if((head == null) || (head.next == null)){
            
            return head;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        
        first.next = swapPairs(second.next);
        second.next = first;
        
        return second;
    }

 public ListNode swapPairsIterative(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        
        while((head != null) && (head.next != null)){
            
            ListNode first = head;
            ListNode second = head.next;
            
            prevNode.next = second;
            first.next = second.next;
            second.next = first;
            
            
            prevNode = first;
            head = first.next; 
            
        }
        
        return dummy.next;
    }
}