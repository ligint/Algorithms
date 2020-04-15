/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        
        return hasPathSum(root.left , sum - root.val) || hasPathSum(root.right , sum - root.val);
        
    }
	
	public boolean hasPathSumIterative(TreeNode root, int sum) {
     
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> total = new Stack();
        
        stack.push(root);
        total.push(sum);
        
        while(!stack.isEmpty() && root != null){
            
            TreeNode current = stack.pop();
            int value = total.pop();
            
            if(current.left == null && current.right == null && current.val == value) return true;
            
            if(current.left != null){
                
                stack.push(current.left);
                total.push(value - current.val);
                
            }
            
            if(current.right != null){
                
                stack.push(current.right);
                total.push(value - current.val);
                
            }
            
        }
        return false;
    }
}