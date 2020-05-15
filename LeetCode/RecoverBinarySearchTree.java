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
    
    TreeNode x = null, y = null, pre = null;
    
    public void swap(TreeNode a , TreeNode b){
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    
    public void findTwoSwapped(TreeNode root){
        if(root == null) return;
        findTwoSwapped(root.left);
        if(pre != null && root.val < pre.val){
            y = root;
            if(x == null)
                x = pre;
            else
                return;
        }
        
        pre = root;
        findTwoSwapped(root.right);
        
    }
    
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x,y);
    }
}