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
        testReverseLinkedList(false);
        testSumLists(false);
        testPalindromeLinkedList(false);
        testIntersectionLinkedList(false);
        testLoopDetectionLinkedList(true);
    }

    private void testLinkedList(boolean active){
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

    private void testRemoveDuplicate(boolean active){
        if (!active)
            return;
        System.out.println("\nTestRemoveDuplicate");
        LinkedList linkedList = getTestLinkedList();
        linkedList.print();
        linkedList.removeSubsequentDuplicates();
        linkedList.print();
    }

    private void testReturnKthToLast(boolean active) {
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

    private void testDeleteMiddleNode(boolean active) {
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
        LinkedList smallLinkedList = getSmallTestLinkedList();
        smallLinkedList.print();
        smallLinkedList.deleteMiddleNode();
        smallLinkedList.print();

        System.out.println("Single element Linked List");
        LinkedList oneElementLinkedList = getOneElementTestLinkedList();
        oneElementLinkedList.print();
        oneElementLinkedList.deleteMiddleNode();
        oneElementLinkedList.print();
    }

    private void testPartition(boolean active) {
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

    private void testSumLists(boolean active) {
        if (!active)
            return;

        System.out.println("\nTestSumLists");
        System.out.println("Test sum 2 equal length Linked Lists, res same length");
        LinkedList sumLinkedList = new LinkedList();
        sumLinkedList = sumLinkedList.sumReversedLists(getFirstReversedLinkedList(), getSecondReversedLinkedList());
        getFirstReversedLinkedList().print();
        getSecondForwardLinkedList().print();
        sumLinkedList.print();
        System.out.println("Test sum 2 equal length Linked Lists, res carry over");
        LinkedList sumLinkedList1 = new LinkedList();
        sumLinkedList1 = sumLinkedList1.sumReversedLists(getFirstReversedLinkedList(), getThirdReversedLinkedList());
        getFirstReversedLinkedList().print();
        getThirdReversedLinkedList().print();
        sumLinkedList1.print();
        System.out.println("Test sum 2 non-equal length Linked Lists,");
        LinkedList sumLinkedList2 = new LinkedList();
        sumLinkedList2 = sumLinkedList2.sumReversedLists(getThirdReversedLinkedList(), getFourthReversedLinkedList());
        getThirdReversedLinkedList().print();
        getFourthReversedLinkedList().print();
        sumLinkedList2.print();
    }

    private void testPalindromeLinkedList(boolean active) {
        if (!active)
            return;

        System.out.println("\nTestPalidromeLinkedList");

        LinkedList palindromeLinkedList = getPalindromeLinkedList();
        palindromeLinkedList.print();
        System.out.println("PalindromeLinkedList: " + palindromeLinkedList.isPalindrome());

        LinkedList nonPalindromeLinkedList = getTestLinkedList();
        nonPalindromeLinkedList .print();
        System.out.println("NonPalindromeLinkedList: " + nonPalindromeLinkedList.isPalindrome());

        LinkedList evenPalindromeLinkedList = getEvenPalindromeLinkedList();
        evenPalindromeLinkedList.print();
        System.out.println("EvenPalindromeLinkedList: " + evenPalindromeLinkedList.isPalindrome());
    }

    private void testIntersectionLinkedList(boolean active) {
        if (!active)
            return;

        System.out.println("\nTestIntersectionLinkedList");

        LinkedList[] equalNonIntersectedLinkedList = getEqualNonIntersectedLinkedLists();
        LinkedList first = equalNonIntersectedLinkedList[0];
        LinkedList second = equalNonIntersectedLinkedList[1];
        System.out.println("EqualNonIntersectedLinkedList: " + first.checkIntersection(second));

        LinkedList[] intersectedLinkedList = getIntersectedLinkedLists();
        LinkedList first1 = intersectedLinkedList[0];
        LinkedList second1 = intersectedLinkedList[1];
        System.out.println("IntersectedLinkedList: " + first1.checkIntersection(second1));
    }

    private void testLoopDetectionLinkedList(boolean active) {
        if (!active)
            return;

        System.out.println("\nTestLoopDetectionLinkedList");
        LinkedList corruptedLinkedList = new LinkedList();
        LinkedList firstHalf = getFirstForwardLinkedList();
        LinkedList secondHalf = getSecondForwardLinkedList();
        corruptedLinkedList.createCircularLinkedList(firstHalf, secondHalf);
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

    private LinkedList getSmallTestLinkedList(){

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

    private LinkedList getPalindromeLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(3);
        linkedList.add(1);
        return linkedList;
    }

    private LinkedList getEvenPalindromeLinkedList(){

        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(9);
        linkedList.add(3);
        linkedList.add(1);
        return linkedList;
    }

    private LinkedList getFirstForwardLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(7);
        return linkedList;
    }

    private LinkedList getSecondForwardLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(2);
        linkedList.add(9);
        linkedList.add(5);
        return linkedList;
    }

    private LinkedList getFirstReversedLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(7);
        linkedList.add(1);
        linkedList.add(6);
        return linkedList;
    }

    private LinkedList getSecondReversedLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(2);
        return linkedList;
    }

    private LinkedList getThirdReversedLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(9);
        linkedList.add(9);
        linkedList.add(9);
        return linkedList;
    }

    private LinkedList getFourthReversedLinkedList(){
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.add(9);
        linkedList.add(9);
        linkedList.add(9);
        linkedList.add(9);
        return linkedList;
    }

    private LinkedList[] getEqualNonIntersectedLinkedLists(){
        LinkedList[] res = new LinkedList[2];

        LinkedList first = new LinkedList<Integer>();
        first.add(9);
        first.add(9);
        first.add(9);
        first.add(9);
        res[0] = first;
        first.print();

        LinkedList second = new LinkedList<Integer>();
        second.add(9);
        second.add(9);
        second.add(9);
        second.add(9);
        res[1] = second;
        second.print();

        return res;
    }

    private LinkedList[] getIntersectedLinkedLists(){
        LinkedList[] res = new LinkedList[2];
        LinkedList intersectingLinkedList = new LinkedList();
        intersectingLinkedList.add(1);
        intersectingLinkedList.add(2);
        intersectingLinkedList.add(3);
;
        LinkedList first = new LinkedList<Integer>();
        first.add(2);
        first.add(9);
        first.add(5);
        first.add(3);
        first.markIntersectingLinkedLists(intersectingLinkedList);
        res[0] = first;
        first.print();

        LinkedList second = new LinkedList<Integer>();
        second.add(9);
        second.add(9);
        second.add(9);
        second.add(9);
        second.markIntersectingLinkedLists(intersectingLinkedList);
        res[1] = second;
        second.print();

        return res;
    }
}
