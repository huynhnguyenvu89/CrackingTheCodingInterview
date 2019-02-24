package StackAndQueue;

import test.VPractive;

public class SetOfStacks extends VPractive {
    private InnerStack headStack;
    private int capacity;
    private int numberOfStack = 0;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int element) {
        if (headStack == null) {
            headStack = new InnerStack(capacity);
            numberOfStack++;
        } else if (headStack.isFull()) {
            InnerStack newStack = new InnerStack(capacity);
            newStack.nextStack = headStack;
            headStack = newStack;
            numberOfStack++;
        }
        headStack.push(element);
    }

    public int pop() {
        InnerStack temp = headStack;
        int res = temp.pop();
        if (temp.isEmpty()) {
            headStack = headStack.nextStack;
            numberOfStack--;
        }
        return res;
    }

    public int getNumberOfStack() {
        return numberOfStack;
    }

    public void print() {
        if (headStack == null)
            return;
        log("*** Print Set Of Stacks: ");
        InnerStack temp = headStack;
        while (temp != null) {
            logInLine("Stack: ");
            Node tempNode = temp.headNode;
            if (tempNode != null) {
                while (tempNode.link != null) {
                    logInLine(tempNode.data + " ==> ");
                    tempNode = tempNode.link;
                }
                log(tempNode.data + "");
            }
            temp = temp.nextStack;
        }
    }

    private class InnerStack {
        private int capacity;
        private InnerStack nextStack;
        private int size;
        private Node headNode;

        InnerStack(int capacity) {
            this.capacity = capacity;
            this.nextStack = null;
            size = 0;
        }

        protected boolean isFull() {
            return size == capacity;
        }

        protected boolean isEmpty() {
            return size == 0;
        }

        protected boolean push(int data) {
            if (isFull()) {
                return false;
            }

            Node newNode = new Node(data);
            if (headNode == null) {
                headNode = newNode;
            } else {
                newNode.link = headNode;
                headNode = newNode;
            }
            size++;
            return true;
        }

        protected int pop() {
            if (isEmpty())
                throw new IndexOutOfBoundsException("Stack is empty. Underflow condition");
            Node temp = headNode;
            headNode = headNode.link;
            size--;
            return temp.data;
        }
    }

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }
}
