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
    
    int maxSum = Integer.MIN_VALUE;
    
    public int maxGain(TreeNode node){
        
        if(node == null)
            return 0;
        
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        
        int newResult = node.val + leftGain + rightGain;
        
        maxSum = Math.max(maxSum, newResult);
        
        return node.val + Math.max(leftGain,rightGain);
        
    }
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}