/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int carry=0;
        ListNode l3 = new ListNode(0);
        ListNode ans=l3;
        while(l1 !=null || l2 !=null)
        {
            sum=(l1 !=null ? l1.val : 0) + (l2 !=null ? l2.val : 0) + carry;
            carry=sum/10;
            sum=sum%10;
            l3.val=sum;
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2=l2.next;
            }
            if(l1!=null || l2!=null || carry > 0)
            {
                l3.next=new ListNode(carry);
                l3=l3.next;
            }
            
        }
        return ans;
    }
}