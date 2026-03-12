public class PalindromeUC2 {

    public static void main(String[] args) {

        // Hardcoded string
        String word = "madam";

        // Reverse the string
        String reverse = "";

        for(int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        // Check palindrome
        if(word.equals(reverse)) {
            System.out.println(word + " is a Palindrome");
        }
        else {
            System.out.println(word + " is NOT a Palindrome");
        }

    }
}