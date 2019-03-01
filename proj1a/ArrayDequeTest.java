public class ArrayDequeTest {
    public static void testAddFirst(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(3);
        A.addFirst(5);
        System.out.println(A.removeFirst());
        System.out.println(A.removeFirst());
        System.out.println(A.removeFirst());
        System.out.println(A.removeFirst());

    }

    public static void testAddLast(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addLast(1);
        A.addLast(2);
        System.out.println(A.removeLast());
        System.out.println(A.removeLast());
        System.out.println(A.removeLast());

    }

    public static void testGet(){
        ArrayDeque<Integer> A = new ArrayDeque<>();

        for(int i=0; i<120;i++) {
            A.addLast(i+1);
        }
        int actual = A.get(4);
        int expected = 5;
        if (actual != expected) {
            System.out.println("error!");
        }

    }

    public static void testPrintDeque(){
        ArrayDeque<Integer> A = new ArrayDeque<>();

        for(int i=0; i<20;i++) {
            A.addLast(i+1);
        }
        A.printDeque();

    }

    public static void testRemoveFirst(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        System.out.println(A.removeFirst());

        for(int i=0; i<20;i++) {
            A.addLast(i+1);
        }

        for(int i=0; i<20;i++) {
            System.out.println(A.removeFirst());
        }


    }

    public static void testRemoveLast(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        System.out.println(A.removeLast());

        for(int i=0; i<20;i++) {
            A.addLast(i+1);
        }

        for(int i=0; i<20;i++) {
            System.out.println(A.removeLast());
        }


    }


    public static void main(String args[]) {
        testAddFirst();
    }

}
