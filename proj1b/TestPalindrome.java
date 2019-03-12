import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));

        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("level"));
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testIsPalindromeWithComparator() {
        CharacterComparator offByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertFalse(palindrome.isPalindrome("level", offByOne));
        assertFalse(palindrome.isPalindrome("LeveL", offByOne));
        assertFalse(palindrome.isPalindrome("axyB", offByOne));

        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("aab", offByOne));
        assertTrue(palindrome.isPalindrome("axyb", offByOne));
        assertTrue(palindrome.isPalindrome("&%", offByOne));
    }
}
