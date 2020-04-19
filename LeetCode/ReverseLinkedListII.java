/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(m > 1){
            
            prev = curr;
            curr = curr.next;
            
            m--;
            n--;
        }
        
        ListNode conn = prev , tail = curr;
        ListNode temp = null;
        
        while(n > 0){
            
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            n--;
        }
        
        if(conn != null){
            conn.next = prev;
        } else{
            head = prev;
        }
        
        tail.next = curr;
        return head;
        
    }
}