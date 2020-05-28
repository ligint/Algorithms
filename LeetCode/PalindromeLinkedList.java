/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        boolean  even=false;
        
        while(fast.next!=null){
            if(fast.next.next==null){
                even=true;
                break;
            }
            slow = slow.next;
            fast=fast.next.next;
        }
        
        ListNode curr=head;
        ListNode mid_next=slow.next;
        ListNode prev=null;
        ListNode temp=null;
        while(curr!=mid_next){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        if(even==false){
            prev=prev.next;
        }
        
        while(curr!=null){
            if(curr.val!=prev.val){
                return false;
            }
            curr=curr.next;
            prev=prev.next;
        }
        return true;
        
    }
}