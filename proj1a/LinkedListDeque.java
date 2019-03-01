public class LinkedListDeque<T>{

    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node() {
            item = null;
            prev = null;
            next = null;
        }

        public Node(T i, Node n){
            item = i;

            prev = n;
            next = n.next;
            n.next.prev = this;
            n.next = this;
        }
    }

    public int size;
    public Node sentinel;

    /* Creates an empty linked list deque */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        new Node(item, sentinel);
        size += 1;

    }

    /*  Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        new Node(item, sentinel.prev);
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }
    /* Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last */
    public void printDeque() {
        Node ptr = sentinel.next;
        for(int i = 0; i < size; i++) {
            System.out.print(ptr.item);
            System.out.print(' ');
            ptr = ptr.next;
        }
    }

    /* Removes and returns the item at the front of the deque */
    public T removeFirst() {
        if(size == 0) return null;
        Node ptr = sentinel.next;
        sentinel.next = ptr.next;
        ptr.next.prev = sentinel;
        size -= 1;
        return ptr.item;
    }

    /* Removes and returns the item at the back of the deque */
    public T removeLast() {
        if(size == 0) return null;
        Node ptr = sentinel.prev;
        sentinel.prev = ptr.prev;
        ptr.prev.next = sentinel;
        size -= 1;
        return ptr.item;
    }

    /* Gets the item at the given index */
    public T get(int index) {
        if(index < 0 || index > size-1) return null;
        Node ptr = sentinel.next;
        for(int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    /* Same as get(int index), but uses recursion */
    public T getRecursive(int index) {
        if(index < 0 || index > size-1) return null;
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node n, int index){
        if(index == 0) return n.item;
        return getRecursive(n.next, index-1);
    }

}