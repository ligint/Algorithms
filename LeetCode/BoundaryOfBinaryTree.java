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
    
    List<Integer> nodes = new ArrayList<>();
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return nodes;
        if(root.left != null || root.right != null)
            nodes.add(root.val);
        
        leftBoundary(root.left);
        leaves(root);
        rightBoundary(root.right);
        
        return nodes;
    }
    
    public void leftBoundary(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    
    public void rightBoundary(TreeNode root){
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val);
    }
    
    public void leaves(TreeNode root){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            nodes.add(root.val);
            return;
        }
        
        leaves(root.left);
        leaves(root.right);
    }
}