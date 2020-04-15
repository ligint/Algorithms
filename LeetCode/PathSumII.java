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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentNode = new ArrayList<>();
        
        findPath(root, sum , currentNode, result);
        
        return result;
    }
    
    public void findPath(TreeNode root, int sum , List<Integer> currentNode, List<List<Integer>> result){
        
        if(root == null)
            return;
        
        currentNode.add(root.val);
        if(root.left == null && root.right == null && sum == root.val)
            result.add(new ArrayList<>(currentNode));
        
        findPath(root.left , sum - root.val, currentNode, result);
        findPath(root.right, sum - root.val, currentNode, result);
        
        currentNode.remove(currentNode.size() - 1);
    }
}