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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int size = q.size();
        
        while(!q.isEmpty() && size --> 0){
            
            TreeNode current = q.remove();
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
            if(size == 0){
                result.add(current.val);
                size = q.size();
            }
            
        }
        
        return result;
    }
}