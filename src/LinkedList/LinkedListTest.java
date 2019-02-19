package LinkedList;

public class LinkedListTest {

    public LinkedListTest(){ }

    private LinkedList getTestLinkedList(){

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
        return linkedList;
    }

    private LinkedList getOddTestLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        return linkedList;
    }

    private LinkedList getEvenTestLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(0);
        return linkedList;
    }

    /**
     *
     * 3 -> 5 -> 8 -> 5 -> 9 -> 2 -> 1 (partition = 5)
     * 3 -> 1 -> 2 -> 9 -> 5 -> 5 -> 8
     * @return
     */
    private LinkedList getUnsortedTestLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(2);
        linkedList.add(1);
        return linkedList;
    }

    public  void testLinkedList(boolean active){
        if (!active)
            return;

        //Test add() method
        LinkedList linkedList = getTestLinkedList();

        //Test remove() method
        linkedList.remove(9);
        linkedList.remove(1);
        linkedList.remove(5);
        linkedList.remove(1);
        linkedList.print();
    }

    private LinkedList getSmalTestLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1);
        return linkedList;
    }

    public void testRemoveDuplicate(boolean active){
        if (!active)
            return;

        LinkedList linkedList = getTestLinkedList();
        linkedList.print();
        linkedList.removeSubsequentDuplicates();
        linkedList.print();
    }

    public void testReturnKthToLast(boolean active) {
        if (!active)
            return;

        LinkedList linkedList = getTestLinkedList();
        linkedList.print();

        System.out.println("Return 0 To Last " + linkedList.returnKthToLast(0));
        System.out.println("Return 1 To Last " + linkedList.returnKthToLast(1));
        System.out.println("Return 5 To Last " + linkedList.returnKthToLast(5));
        System.out.println("Return 9 To Last " + linkedList.returnKthToLast(9));
        System.out.println("Return 100 To Last " + linkedList.returnKthToLast(100));
    }

    public void testDeleteMiddleNode(boolean active) {
        if (!active)
            return;

        LinkedList evenLinkedList = getEvenTestLinkedList();
        evenLinkedList.print();
        evenLinkedList.deleteMiddleNode();
        evenLinkedList.print();

        LinkedList oddLinkedList = getOddTestLinkedList();
        oddLinkedList.print();
        oddLinkedList.deleteMiddleNode();
        oddLinkedList.print();

        LinkedList smallLinkedList = getSmalTestLinkedList();
        smallLinkedList.print();
        smallLinkedList.deleteMiddleNode();
        smallLinkedList.print();
    }

    public void testPartition(boolean active) {
        if (!active)
            return;

        LinkedList unsortedTestLinkedList = getUnsortedTestLinkedList();
        unsortedTestLinkedList.print();
        unsortedTestLinkedList.partition(5);
        unsortedTestLinkedList.print();
    }
}
