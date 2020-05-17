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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int[] listNode,table;
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        listNode = linkedListToArray(head);
        table = computeKMPTable(listNode);
        return kmpSearch(root, 0);
    }
    
    public boolean kmpSearch(TreeNode i, int j){
        if(j == listNode.length) return true;
        if(i == null) return false;
        
        while(j > 0 && i.val != listNode[j]) j = table[j - 1];
        if(i.val == listNode[j]) j++;
        
        return kmpSearch(i.left, j) || kmpSearch(i.right,j);
        
    }
    
    public int[] computeKMPTable(int[] listNode){
        int n = listNode.length;
        int[] table = new int[n];
        for(int i = 1, j = 0; i < n; i++){
            while(j > 0 && table[i] != table[j]){
                j = table[j - 1];
            }
            
            if(table[i] == table[j])
                table[i] = ++j;
        }
        
        return table;
        
    }
    
    public int[] linkedListToArray(ListNode head){
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }   
        
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size();i++)
            arr[i] = list.get(i);
        
        return arr;
    }
}