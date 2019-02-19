package LinkedList;

public class LinkedListTest {

    private static LinkedList getTestLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        return linkedList;
    }

    public static void testLinkedList(){
        //Test add() method
        LinkedList linkedList = getTestLinkedList();

        //Test remove() method
        linkedList.remove(9);
        linkedList.remove(1);
        linkedList.remove(5);
        linkedList.remove(1);
        linkedList.print();
    }

    public static void testRemoveDuplicate(){
        LinkedList linkedList = getTestLinkedList();
        linkedList.print();
        linkedList.removeSubsequentDuplicates();
        linkedList.print();
    }
}
