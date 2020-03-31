class Solution {
    public int countSubstrings(String s) {
        
        int N = s.length();
        int ans = 0;
        
        for(int i = 0; i <= 2*N - 1; i++){
            
            int left = i/2;
            int right = left + i % 2;
            
            while(left >= 0 && right < N && s.charAt(left) == s.charAt(right)){
                
                ans++;
                left--;
                right++;
            }
            
        }
        return ans;
    }
}