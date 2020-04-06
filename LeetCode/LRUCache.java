class LRUCache {
    
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(){}
        
        public Node(int k , int val){
            
            key = k;
            value = val;
        } 
    }
    
    private void addNode(Node node){
        
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node){
        
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void addToFront(Node node){
        
        removeNode(node);
        addNode(node);
        
    }
    
    private Node popTail(){
        Node node = tail.prev;
        removeNode(node);
        return node;
        
    }
    
    Node head;
    Node tail;
    Map<Integer,Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
        
        cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)){
            return -1;
        }
        
        Node node = cache.get(key);
        
        addToFront(node);
        
        return node.value;
        
    }
    
    public void put(int key, int value) {
        
         if(!cache.containsKey(key)){
            
            Node node = new Node(key,value);
            addNode(node);
            cache.put(key,node);
            
            if(cache.size() > capacity){
                
                Node del = popTail();
                cache.remove(del.key);
            }
            
        }
        else{
            
            Node node = cache.get(key);
            node.value = value;
            addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */