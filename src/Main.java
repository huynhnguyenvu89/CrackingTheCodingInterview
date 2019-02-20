import test.ArraysStringsTest;
import test.LinkedListTest;

public class Main {
    public static void main(String[] args) {

        //Run ArrayString test suite
        ArraysStringsTest arraysStringsTest = new ArraysStringsTest(false);
        arraysStringsTest.runTestSuite(false);

        //Run LinkedList tests suite
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.runTestSuite(true);
    }
}
