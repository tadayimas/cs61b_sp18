import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy1 = new OffByN(1);
    static CharacterComparator offBy4 = new OffByN(4);

    @Test
    public void testEqualChars() {
        assertTrue(offBy1.equalChars('a', 'b'));
        assertTrue(offBy1.equalChars('&', '%'));
        assertFalse(offBy1.equalChars('a', 'c'));

        assertTrue(offBy4.equalChars('a', 'e'));
        assertFalse(offBy4.equalChars('a', 'f'));
    }

}
