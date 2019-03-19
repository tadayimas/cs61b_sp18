package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(1);
        arb.enqueue(4);
        arb.enqueue(10);
        arb.enqueue(15);
        assertEquals(4, arb.fillCount());

        assertEquals(1, (int) arb.dequeue());
        assertEquals(4, (int) arb.dequeue());
        assertEquals(10, (int) arb.peek());
        assertEquals(10, (int) arb.dequeue());
        assertEquals(1, arb.fillCount());


    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
