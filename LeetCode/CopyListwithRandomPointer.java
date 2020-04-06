/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    HashMap<Node,Node> visited = new HashMap<>();
    
    public Node getCloned(Node node){
        
        if(node != null){
            
            if(visited.containsKey(node)){
                return visited.get(node);
            }
                
        else{
            
            visited.put(node, new Node(node.val,null,null));
            return visited.get(node);
        }
      }
        return null;
    }
    
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Node oldNode = head;
        
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode,newNode);
        
        while(oldNode != null){
            
            newNode.random = getCloned(oldNode.random);
            newNode.next = getCloned(oldNode.next);
            
            oldNode = oldNode.next;
            newNode = newNode.next;
            
        }
        
        return visited.get(head);
    }
}