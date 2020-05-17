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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return null;
        int sum = 0;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0,dummy);
        
        while(head != null){
            sum += head.val;
            map.put(sum,head);
            head = head.next;
        }
        
        head = dummy;
        sum = 0;
        
        while(head != null){
            sum += head.val;
            
            ListNode dup = map.get(sum);
            if(dup != head){
                head.next = dup.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}