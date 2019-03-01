import test.ArraysStringsTest;
import test.LinkedListTest;
import test.StackAndQueueTest;
import test.TreeAndGraphTest;

public class Main {
    public static void main(String[] args) {

        //Run ArrayString test suite
        ArraysStringsTest arraysStringsTest = new ArraysStringsTest(false);
        arraysStringsTest.runTestSuite(false);

        //Run LinkedList tests suite
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.runTestSuite(false);

        StackAndQueueTest stackAndQueueTest = new StackAndQueueTest();
        stackAndQueueTest.runTestSuite(false);

        TreeAndGraphTest treeAndGraphTest = new TreeAndGraphTest();
        treeAndGraphTest.runTestSuite(true);
    }
}
