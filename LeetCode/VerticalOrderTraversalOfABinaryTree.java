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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        int min = 0, max = 0;
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        if(root == null) return results;
        
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> hdist = new LinkedList<>();
        
        node.add(root);
        hdist.add(0);
        
        while(!node.isEmpty()){
            
            int size = node.size();
            HashMap<Integer, List<Integer>> temp = new HashMap<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode curr = node.poll();
                int index = hdist.poll();
                
                if(!temp.containsKey(index)) temp.put(index, new ArrayList<>());
                temp.get(index).add(curr.val);
                
                if(index < min) min = index;
                if(index > max) max = index;
                
                if(curr.left != null){
                    node.add(curr.left);
                    hdist.add(index - 1);
                }
                if(curr.right != null){
                    node.add(curr.right);
                    hdist.add(index + 1);
                }
            }
            
            for(int key : temp.keySet()){
                
                if(!map.containsKey(key)) map.put(key, new ArrayList<>());
                List<Integer> list = temp.get(key);
                Collections.sort(list);
                map.get(key).addAll(list);
            }
        }
        
        for(int i = min; i <= max; i++){
            
            List<Integer> out = map.get(i);
            results.add(out);
        }
        return results;
    }
}