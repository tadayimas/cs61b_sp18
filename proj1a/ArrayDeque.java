public class ArrayDeque<T> {
    private int size;
    private T[] items = (T []) new Object[8];
    private int nextFirst;
    private int nextLast;

    private void resize(double factor){
        T[] items2 = (T []) new Object[(int) (items.length * factor)];
        int p = (nextFirst + 1) % items.length;
        for(int i = 0; i < size; i++) {
            items2[i] = items[p];
            p = (p + 1) % items.length;
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


    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if(size == items.length) resize(2);
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) % items.length;
        size += 1;
    }

    /*  Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if(size == items.length) resize(2);
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }
    /* Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last */
    public void printDeque() {
        int p = (nextFirst + 1) % items.length;
        for(int i = 0; i < size; i++) {
            System.out.print(items[p]);
            System.out.print(' ');
            p = (p + 1) % items.length;
        }
    }

    /* Removes and returns the item at the front of the deque */
    public T removeFirst() {
        if(size == 0) return null;

        double FACTOR = 0.25;
        double factor = ((double)size) / items.length;
        if(factor < FACTOR) resize(0.5);

        int p = (nextFirst + 1) % items.length;
        nextFirst = p;
        T temp = items[p];
        items[p] = null;
        size -= 1;
        return temp;

    }

    /* Removes and returns the item at the back of the deque */
    public T removeLast() {
        if(size == 0) return null;

        double FACTOR = 0.25;
        double factor = ((double)size) / items.length;
        if(factor < FACTOR) resize(0.5);

        int p = (nextLast - 1) % items.length;
        nextLast = p;
        T temp = items[p];
        items[p] = null;
        size -= 1;
        return temp;

    }

    /* Gets the item at the given index */
    public T get(int index) {
        if(index < 0 || index > size-1) return null;
        int p = (nextFirst + 1) % items.length;
        for(int i = 0; i < index; i++) {
            p = (p + 1) % items.length;
        }
        return items[p];

    }



}
