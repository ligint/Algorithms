/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode l3 = new ListNode(-1);
        ListNode ans = l3;
        
        while(l1 != null &&  l2 != null){
            
            if(l1.val <= l2.val){
                
                ans.next = l1;
                l1 = l1.next;
            } else {
                
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        
        ans.next = l1 == null ? l2 : l1;
        return l3.next;
    }
}