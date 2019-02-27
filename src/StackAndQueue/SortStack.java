package StackAndQueue;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array). The stack supports the
 * following operations: push, pop, peek and isEmpty
 */
public class SortStack {
    private Node head;

    public SortStack() {
        head = null;
    }

    public void push(int data) {

    }

    public int pop() {
        Node temp = head;
        head = head.link;
        return temp.data;
    }

    public int peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            link = null;
        }
    }
}
