import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class ReverseStringStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }
}



public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        PalindromeStrategy reverseStrategy = new ReverseStringStrategy();


        boolean result1 = reverseStrategy.checkPalindrome(input);



        System.out.println("Input : " + input);

        System.out.println("Reverse Strategy Result : " + result1);

    }
}