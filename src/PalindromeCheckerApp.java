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

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        PalindromeStrategy reverseStrategy = new ReverseStringStrategy();
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        long start1 = System.nanoTime();
        boolean result1 = reverseStrategy.checkPalindrome(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = stackStrategy.checkPalindrome(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = dequeStrategy.checkPalindrome(input);
        long end3 = System.nanoTime();

        System.out.println("Input : " + input);

        System.out.println("Reverse Strategy Result : " + result1);
        System.out.println("Execution Time (ns) : " + (end1 - start1));

        System.out.println("Stack Strategy Result : " + result2);
        System.out.println("Execution Time (ns) : " + (end2 - start2));

        System.out.println("Deque Strategy Result : " + result3);
        System.out.println("Execution Time (ns) : " + (end3 - start3));
    }
}