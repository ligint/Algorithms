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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr != null){
            
            while(curr != null){
                
                stack.push(curr);
                results.addFirst(curr.val);
                curr = curr.right;
            }
            
            curr = stack.pop();
            curr = curr.left;
        }
        
        return results;
    }
}