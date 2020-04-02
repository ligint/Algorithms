public class Question2 {

    public static void main(String[] args){

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChar(word));
        }
    }

    private static boolean isUniqueChar(String S) {

        if(S.length() > 26)
            return false;
        int checker = 0;

        for(int i = 0; i < S.length();i++){

            int val = S.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

}