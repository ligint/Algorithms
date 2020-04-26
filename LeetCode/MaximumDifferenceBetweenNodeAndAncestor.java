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
    public int maxAncestorDiff(TreeNode root) {
        
        return dfs(root, root.val, root.val);
    }
    
    public int dfs(TreeNode root, int maxVal , int minVal){
        
        if(root == null) return maxVal - minVal;
        
        maxVal = Math.max(maxVal, root.val);
        minVal = Math.min(minVal, root.val);
        
        return Math.max(dfs(root.left, maxVal, minVal), dfs(root.right, maxVal, minVal));
    }
}