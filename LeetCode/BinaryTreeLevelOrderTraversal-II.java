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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
     
        LinkedList<List<Integer>> results = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
            return results;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                
            }
            results.addFirst(level);
        }
        return results;
    }
}