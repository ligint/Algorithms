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
    public List<Integer> preorderTraversal(TreeNode root) {
     
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr != null){
            
            while(curr != null){
                
                results.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            curr = curr.right;
        }
        
        return results;
    }
}