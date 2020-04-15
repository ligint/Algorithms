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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        helper(root, sb, result);
        
        return result;
    }
    
    public void helper(TreeNode root, StringBuilder sb, List<String> result){
        
        if(root == null)
            return;
        
        int len = sb.length();
        sb.append(root.val);
        
        if(root.left == null && root.right == null){
            
            result.add(sb.toString());
        } else {
            
            sb.append("->");
            helper(root.left, sb, result);
            helper(root.right, sb, result);
        }
        
        sb.setLength(len);
        
    }
}