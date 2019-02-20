package test;

import LinkedList.LinkedList;

public class LinkedListTest {

    public LinkedListTest(){ }

    public void runTestSuite(boolean active){
        if (!active)
            return;

        testLinkedList(false);
        testRemoveDuplicate(false);
        testReturnKthToLast(false);
        testDeleteMiddleNode(false);
        testPartition(false);
        testReverseLinkedList(true);
    }

    public  void testLinkedList(boolean active){
        if (!active)
            return;

        //Test add() method
        LinkedList linkedList = getTestLinkedList();
        System.out.println("\nTestLinkedList");

        linkedList.print();
        //Test remove() method
        linkedList.remove(0);
        System.out.println("Remove head 0");
        linkedList.print();
        linkedList.remove(9);
        System.out.println("Remove tail 9");
        linkedList.print();
        linkedList.remove(5);
        System.out.println("Remove mid-element 5");
        linkedList.print();
        linkedList.remove(5);
        System.out.println("Remove non-existent element 5");
        linkedList.print();
        linkedList.remove(100);
        System.out.println("Remove out of scope 100");
        linkedList.print();
    }

    private LinkedList getSmalTestLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1);
        return linkedList;
    }

    private LinkedList getOneElementTestLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        return linkedList;
    }

    public void testRemoveDuplicate(boolean active){
        if (!active)
            return;
        System.out.println("\nTestRemoveDuplicate");
        LinkedList linkedList = getTestLinkedList();
        linkedList.print();
        linkedList.removeSubsequentDuplicates();
        linkedList.print();
    }

    public void testReturnKthToLast(boolean active) {
        if (!active)
            return;

        LinkedList linkedList = getTestLinkedList();
        System.out.println("\nTestReturnKthToLast");
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

        System.out.println("\nTestDeleteMiddleNode");
        System.out.println("Even Linked List");
        LinkedList evenLinkedList = getEvenTestLinkedList();
        evenLinkedList.print();
        evenLinkedList.deleteMiddleNode();
        evenLinkedList.print();

        System.out.println("Odd Linked List");
        LinkedList oddLinkedList = getOddTestLinkedList();
        oddLinkedList.print();
        oddLinkedList.deleteMiddleNode();
        oddLinkedList.print();

        System.out.println("2 elements Linked List");
        LinkedList smallLinkedList = getSmalTestLinkedList();
        smallLinkedList.print();
        smallLinkedList.deleteMiddleNode();
        smallLinkedList.print();

        System.out.println("Single element Linked List");
        LinkedList oneElementLinkedList = getOneElementTestLinkedList();
        oneElementLinkedList.print();
        oneElementLinkedList.deleteMiddleNode();
        oneElementLinkedList.print();
    }

    public void testPartition(boolean active) {
        if (!active)
            return;

        System.out.println("\nTestPartition");
        System.out.println("Unsorted Linked List - contains partition value");
        LinkedList unsortedTestLinkedList = getUnsortedTestLinkedList();
        unsortedTestLinkedList.print();
        unsortedTestLinkedList.partition(5);
        unsortedTestLinkedList.print();

        System.out.println("Single element Linked List");
        LinkedList oneElementLinkedList = getOneElementTestLinkedList();
        oneElementLinkedList.print();
        oneElementLinkedList.partition(5);
        oneElementLinkedList.print();

        System.out.println("Unsorted Linked List - large partition value, not in list");
        LinkedList testLinkedList = getTestLinkedList();
        testLinkedList.print();
        testLinkedList.partition(100);
        testLinkedList.print();

        System.out.println("Unsorted Linked List - small partition value, not in list");
        LinkedList testLinkedList2 = getTestLinkedList();
        testLinkedList2.print();
        testLinkedList2.partition(-1);
        testLinkedList2.print();
    }

    private void testReverseLinkedList(boolean active) {
        if (!active)
            return;

        System.out.println("\nTestReverseLinkedList");
        System.out.println("Normal Linked List");
        LinkedList testLinkedList = getTestLinkedList();
        testLinkedList.print();
        testLinkedList.reverseLinkedList();
        testLinkedList.print();

        System.out.println("Single element Linked List");
        LinkedList oneElementLinkedList = getOneElementTestLinkedList();
        oneElementLinkedList.print();
        oneElementLinkedList.reverseLinkedList();
        oneElementLinkedList.print();
    }

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
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(1);
        return linkedList;
    }
}
