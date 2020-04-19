/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElementsIterative(ListNode head, int val) {
        
        if(head == null)
            return null;
        
        ListNode curr = head;
        ListNode temp = head.next;
        
        
        while(temp != null){
            if(temp.val != val)
                curr = curr.next;
            else
                curr.next = temp.next;
            
            temp = temp.next;
        }
        
        if(head.val == val){
            return head.next;
        }
        else
            return head;
    }
	public ListNode removeElementsRecursive(ListNode head, int val) {
        
        if(head == null)
            return head;
        
        ListNode temp = removeElements(head.next, val);
        if(head.val ==  val) return temp;
        head.next = temp;
        return head;
    }
}