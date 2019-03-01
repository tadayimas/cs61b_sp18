public class ArrayDequeTest {
    public static void testAddFirst(){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(3);
        A.addFirst(5);

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




    public static void main(String args[]) {
        testGet();
    }

}
