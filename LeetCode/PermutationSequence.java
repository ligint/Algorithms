class Solution {
    public String getPermutation(int n, int k) {
     
        int index = 0;
        List<Integer> num = new ArrayList<>();
        
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        
        int sum = 1;
        factorial[0] = 1;
        
        for(int i = 1; i <= n; i++){
            
            sum *= i;
            factorial[i] = sum;
        }
        
        for(int i = 1; i <=n ;i++){
            num.add(i);
        }
        
        k--;
        
        for(int i = 1; i <=n; i++){
            index = k / factorial[n - i];
            sb.append(String.valueOf(num.get(index)));
            num.remove(index);
            k -= index * factorial[n - i];
        }
        return String.valueOf(sb);
    }
}