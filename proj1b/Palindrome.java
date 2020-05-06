public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        return isPalindromeHelper(wordToDeque(word));
    }

    /**
     * Creates a Helper method for isPalindrome.
     */
    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        if (deque.removeFirst() != deque.removeLast()) {
            return false;
        }
        deque.removeFirst();
        deque.removeLast();
        return isPalindromeHelper(deque);
    }

    //Overload isPalindrome.
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(wordToDeque(word), cc);
    }

    /**Helps the overloaded isPalindrome
     */
    private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return false;
        }
        deque.removeFirst();
        deque.removeLast();
        return isPalindromeHelper(deque, cc);
    }

    /**
     *Just want to check the JavaVisualizer
     */

    /*
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome("A");
    }

     */






}
