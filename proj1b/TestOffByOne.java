import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
     **/
    CharacterComparator offbyone = new OffByOne();
    @Test
    public void testEqualChars() {
        assertFalse(offbyone.equalChars('a', 'a'));
        assertFalse(offbyone.equalChars('a', 'A'));
        assertFalse(offbyone.equalChars('a', 'z'));
        assertTrue(offbyone.equalChars('a', 'b'));
        assertTrue(offbyone.equalChars('r', 'q'));
        assertFalse(offbyone.equalChars('a', 'B'));
    }
}
