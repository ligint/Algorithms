/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
     
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((n1 , n2) -> {
            
            return n1.val - n2.val;
        });
            
        for(int i = 0; i < lists.length; i++){
            
            ListNode n = lists[i];
            while(n != null){
                
                q.add(n);
                n = n.next;
            }
        }
        
        ListNode head = null, tail = null;
        while(!q.isEmpty()){
            if(head == null){
                
                head = q.poll();
                tail = head;
            } else {
                
                ListNode l = new ListNode(q.poll().val);
                tail.next = l;
                tail = tail.next;
            }
        }
        return head;
    }
}