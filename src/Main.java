import ArraysStrings.*;
import ArraysStrings.StringBuilder;
import LinkedList.LinkedListTest;

public class Main {
    public static void main(String[] args) {

        //ArrayString test suite
        ArraysStringsTest arraysStringsTest = new ArraysStringsTest(false);
        arraysStringsTest.testIsRotation();
        arraysStringsTest.testZeroMatrix();
        arraysStringsTest.testRotateMatrix();
        arraysStringsTest.testArrayStringCompression();
        arraysStringsTest.testArrayStringOneAway();
        arraysStringsTest.testArrayStringPalindromePermutation();
        arraysStringsTest.testArrayStringURLify();
        arraysStringsTest.testStringBuilder();
        arraysStringsTest.testHashTable();
        arraysStringsTest.testArrayList();
        arraysStringsTest.testArrayStringCheckPermutation();


//        LinkedListTest.testLinkedList();
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.testLinkedList(false);
        linkedListTest.testRemoveDuplicate(false);
        linkedListTest.testReturnKthToLast(false);
        linkedListTest.testDeleteMiddleNode(true);
    }
}
