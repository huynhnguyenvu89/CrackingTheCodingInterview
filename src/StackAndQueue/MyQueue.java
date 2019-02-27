package StackAndQueue;

import test.VPractive;

/**
 * Implement MyQueue class which implement a queue using two stacks
 */
public class MyQueue extends VPractive {
    Stack latestStack;

    public MyQueue(){
        latestStack = new Stack();
    }

    public void add(int data) {
        latestStack.push(data);
    }

    public void remove(){
        Stack oldestStack = new Stack();
        while (latestStack.head != null) {
            oldestStack.push(latestStack.head.data);
            latestStack.head = latestStack.head.link;
        }
        oldestStack.pop();
        while(oldestStack.head != null){
            latestStack.push(oldestStack.head.data);
            oldestStack.head = oldestStack.head.link;
        }
    }

    public void print(){
        latestStack.print();
    }

    class Node {
        int data;
        Node link;
        Node(int data) {
            this.data = data;
        }
    }

    public class Stack {
        Node head;

        Stack(){
            head = null;
        }

        public void push(int data) {
            Node node = new Node(data);
            if (head == null) {
                head = node;
            } else {
                node.link = head;
                head = node;
            }
        }

        public int pop(){
            if (head == null)
                return -1;
            Node temp = head;
            head = head.link;
            return temp.data;
        }

        public void print(){
            if (head == null){
                log("Empty Stack");
                return;
            }
            Node node = head;
            log("Print Stack: ");
            while (node.link != null){
                logInLine(node.data + " ==> ");
                node = node.link;
            }
            log(node.data + "");
        }
    }

    public void testStack(){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();
    }
}
