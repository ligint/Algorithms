class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int result = 0;
        
        Stack<Integer> s = new Stack<>();
        s.push(Integer.MAX_VALUE);
        for(int a : arr){
            while(s.peek() <= a){
                
                int mid = s.pop();
                result += mid * Math.min(s.peek(),a);
            }
            s.push(a);
        }
        
        while(s.size() > 2){
            result += s.pop() * s.peek();
        }
        return result;
    }
}