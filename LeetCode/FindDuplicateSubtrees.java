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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        List<TreeNode> results = new LinkedList<>();
        preorder(root, new HashMap<>(),results);
        
        return results;
        
    }
    
    public String preorder(TreeNode current, HashMap<String,Integer> map, List<TreeNode> results){
        
        if(current == null) return "#";
        
        String output = current.val + "," + preorder(current.left,map,results) + "," + preorder(current.right,map,results);
        if(map.getOrDefault(output,0) == 1) results.add(current);
        
        map.put(output,map.getOrDefault(output,0) + 1);
        
        return output;
        
    }
}