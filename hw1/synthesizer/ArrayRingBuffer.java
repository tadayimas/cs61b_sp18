package synthesizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TODO Make sure to make this class and all of its methods public
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO  Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        first = 0;
        last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return (new MyIterator()).copy.iterator();
    }
    private class MyIterator {
        private List<T> copy = new ArrayList<>(capacity);

        public MyIterator() {
            int len = fillCount;
            for (int i = 0; i < len; i++) {
                T val = dequeue();
                enqueue(val);
                copy.add(val);
            }
        }

//        @Override
//        public boolean hasNext() {
//            return len > 0;
//        }
//
//        @Override
//        public T next() {
//            T val = dequeue();
//            enqueue(val);
//            len -= 1;
//            return val;
//        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO  Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1) % this.capacity;
    }


    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO  Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T val = rb[first];
        fillCount -= 1;
        first = (first + 1) % this.capacity;
        return val;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO  Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];
    }

    // TODO  When you get to part 5, implement the needed code to support iteration.
}
