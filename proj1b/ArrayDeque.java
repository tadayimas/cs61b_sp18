public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private T[] items = (T []) new Object[8];
    private int nextFirst;
    private int nextLast;


    private int mod(int x, int y) {
        int result = x % y;
        if (result < 0) {
            result += y;
        }
        return result;
    }

    private void resize(double factor) {
        T[] items2 = (T []) new Object[(int) (items.length * factor)];
        int p = mod((nextFirst + 1), items.length);
        for (int i = 0; i < size; i++) {
            items2[i] = items[p];
            p = mod((p + 1), items.length);
        }

        items = items2;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /* Creates an empty array deque */
    public ArrayDeque() {
        size = 0;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    @Override
    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(2);
        }
        items[nextFirst] = item;
        nextFirst = mod((nextFirst - 1), items.length);
        size += 1;
    }

    @Override
    /*  Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if (size == items.length) {
            resize(2);
        }
        items[nextLast] = item;
        nextLast = mod((nextLast + 1), items.length);
        size += 1;
    }

    @Override
    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    /* Returns the number of items in the deque */
    public int size() {
        return size;
    }

    @Override
    /* Prints the items in the deque from first to last */
    public void printDeque() {
        int p = mod((nextFirst + 1), items.length);
        for (int i = 0; i < size; i++) {
            System.out.print(items[p]);
            System.out.print(' ');
            p = mod((p + 1), items.length);
        }
    }

    @Override
    /* Removes and returns the item at the front of the deque */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        double scale = 0.25;
        double ratio = ((double) size) / items.length;
        if (ratio < scale) {
            resize(0.5);
        }

        int p = mod((nextFirst + 1), items.length);
        nextFirst = p;
        T temp = items[p];
        items[p] = null;
        size -= 1;
        return temp;

    }

    @Override
    /* Removes and returns the item at the back of the deque */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        double scale = 0.25;
        double ratio = ((double) size) / items.length;
        if (ratio < scale) {
            resize(0.5);
        }

        int p = mod((nextLast - 1), items.length);
        nextLast = p;
        T temp = items[p];
        items[p] = null;
        size -= 1;
        return temp;

    }

    @Override
    /* Gets the item at the given index */
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int p = mod((nextFirst + 1 + index), items.length);
        return items[p];

    }



}
