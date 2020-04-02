public class Question1 {

    public static void main(String[] args){

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }
    public static boolean isUnique(String S){
        if(S.length() > 128)
            return false;

        boolean[] set = new boolean[128];
        for(int i = 0; i < S.length(); i++){

            int val = S.charAt(i);
            if(set[val]) return false;
            set[val] = true;
        }

        return true;
    }

}