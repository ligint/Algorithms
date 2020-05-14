class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        int preTime = 0;
        for(String log : logs){
            
            String[] out = log.split(":");
            if(out[1].equals("start")){
                if(!stack.isEmpty())
                    result[stack.peek()] += Integer.parseInt(out[2]) - preTime;
                stack.push(Integer.parseInt(out[0]));
                preTime = Integer.parseInt(out[2]);
            } else{
                
                result[stack.pop()] += Integer.parseInt(out[2]) - preTime + 1;
                preTime = Integer.parseInt(out[2]) + 1;
            }
        }
        return result;
    }
}