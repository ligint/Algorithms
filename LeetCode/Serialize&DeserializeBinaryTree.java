/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private final String splitter = ",";
    private final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        
        if(root == null){
            
            sb.append(NN).append(splitter);
        } else{
            
            sb.append(root.val).append(splitter);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(q);
    }
    
    private TreeNode buildTree(Deque<String> q){
        
        String a = q.remove();
        if(a.equals(NN)){
            
            return null;
        } else{
            
            TreeNode node = new TreeNode(Integer.valueOf(a));
            node.left = buildTree(q);
            node.right = buildTree(q);
            
            return node;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));