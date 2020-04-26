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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            boolean isX = false;
            boolean isY = false;
            
            for(int i = 0; i < size; i++){
                
                TreeNode current = q.poll();
                if(current.val == x) isX = true;
                if(current.val == y) isY = true;
                
                if(current.left != null && current.right != null){
                    
                    if(current.left.val == x && current.right.val == y){
                        return false;
                    }
                    if(current.left.val == y && current.right.val == x){
                        return false;
                    }
                }
                
                if(current.left != null){
                    
                    q.offer(current.left);
                }
                
                if(current.right != null){
                    
                    q.offer(current.right);
                }
                
            }
            if(isX && isY) return true;
        }
        return false;
    }
}