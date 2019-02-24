package test;

import StackAndQueue.Queue;
import StackAndQueue.Stack;
import StackAndQueue.StackArray;

public class StackAndQueueTest<T> {
    public StackAndQueueTest(){}

    public void runTestSuite(boolean active){
        if (!active)
            return;
        testStackImplementationUsingArray(false);
        testStackImplementationUsingLinkedList(false);
        testQueue(false);
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
