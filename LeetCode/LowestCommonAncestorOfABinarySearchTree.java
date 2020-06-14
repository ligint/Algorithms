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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        int current = root.val;
        
        int a = p.val;
        int b = q.val;
        
        if(a > current && b > current){
            return lowestCommonAncestor(root.right, p, q);
        } else if(a < current && b < current){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}