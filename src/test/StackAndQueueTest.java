package test;

import StackAndQueue.*;

public class StackAndQueueTest<T> {
    public StackAndQueueTest(){}

    public void runTestSuite(boolean active){
        if (!active)
            return;
        testStackImplementationUsingArray(false);
        testStackImplementationUsingLinkedList(false);
        testQueue(false);
        testStackThreeInOne(false);
        testStackMin(false);

    }

    private void testStackMin(boolean active) {
        if (!active)
            return;

        StackMin stackMin = new StackMin();
        stackMin.push(3);
        stackMin.push(4);
        stackMin.push(7);
        stackMin.push(1);

        log("Stack min value " + stackMin.min());
        stackMin.pop();
        stackMin.print();
        log("Stack min value " + stackMin.min());
        stackMin.pop();
        stackMin.pop();
        stackMin.print();
        log("Stack min value " + stackMin.min());
        stackMin.pop();
    }

    private void testStackThreeInOne(boolean active){
        if (!active)
            return;
        MultiStackInOneArray multiStackInOneArray = new MultiStackInOneArray(Integer.class, 3, 2, 5);

        try {
            log("Check first stack empty " + multiStackInOneArray.isEmpty(0));
            log("Check second stack empty " + multiStackInOneArray.isEmpty(1));
            log("Check third stack empty " + multiStackInOneArray.isEmpty(2));
            log("Check stack -1 empty " + multiStackInOneArray.isEmpty(-1));
        } catch (Exception e) {
            log("Intended exception " + e.toString());
        }

        try {
            multiStackInOneArray.pushToStack(1, 1);
            multiStackInOneArray.pushToStack(2, 1);
            multiStackInOneArray.pushToStack(3, 1);
        } catch (Exception e) {
            log("Intended exception " + e.toString());
        }

        try {
            log("Pop " + multiStackInOneArray.popFromStack(1));
            log("Pop " + multiStackInOneArray.popFromStack(1));
            log("Pop " + multiStackInOneArray.popFromStack(1));
        } catch (Exception e) {
            log("Intended exception " + e.toString());
        }
    }

    private void testQueue(boolean active) {
        if (!active)
            return;

        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(6);
        queue.add(10);
        queue.print();
        queue.remove();
        queue.print();
        try {
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.remove();
            queue.print();
        } catch (Exception e){
            log("Underflow expected!");
        }
    }

    private void testStackImplementationUsingLinkedList(boolean active) {
        if (!active)
            return;

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(1);
        stack.print();
        stack.pop();
        stack.print();
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.print();
        } catch (Exception e){
            log("Underflow expected!");
        }
    }

    private void log(String msg){
        MyLog.log(msg);
    }

    private void testStackImplementationUsingArray(boolean active){
        if (!active)
            return;
        log("TestArrayImplementationUsingArray");
        StackArray stack = new StackArray(Integer.class);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(6);
        stack.push(1);
        stack.print();
        stack.pop();
        stack.print();
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.print();
        } catch (Exception e){
            log("Underflow expected!");
        }
    }


}
