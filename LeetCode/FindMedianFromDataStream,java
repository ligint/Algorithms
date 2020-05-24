class MedianFinder {

    /** initialize your data structure here. */
    
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    
    public MedianFinder() {
        
        left = new PriorityQueue<>((a,b) -> b.compareTo(a));
        
        right = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        
        if(left.isEmpty()){
            left.add(num);
        } else{
            if(num > left.peek()){
                right.add(num);
                if(right.size() > left.size()){
                    left.add(right.poll());
                }
            } else {
                left.add(num);
                if(left.size() > right.size())
                    right.add(left.poll());
            }
        }
        
    }
    
    public double findMedian() {
        
        if(left.size() == right.size()){
            return ((double) (left.peek() + right.peek())) / 2;
        }
        else if(left.size() > right.size()){
            return left.peek();
        } else{
            return right.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */