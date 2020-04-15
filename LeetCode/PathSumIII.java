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
    
    public int findPath(TreeNode root, int currentSum , int sum, HashMap<Integer, Integer> map){
        
        if(root == null)
            return 0;
        
        currentSum += root.val;
        
        int result = map.getOrDefault(currentSum - sum, 0);
        map.put(currentSum, map.getOrDefault(currentSum,0) + 1);
        
        result += findPath(root.left, currentSum, sum, map) +  findPath(root.right, currentSum, sum, map);
        
        map.put(currentSum, map.get(currentSum) - 1);
        
        return result;
        
    }
    
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
            
        return findPath(root, 0, sum, map);
    }
}