package StackAndQueue;

import test.VPractive;

public class StackMin extends VPractive {
    private Node head;

    public StackMin() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int element) {
        if (head == null) {
            head = new Node(element, element);
        } else {
            Node newNode;
            int currentSubStackMin = head.subStackMin;
            if (currentSubStackMin <= element) {
                newNode = new Node(element, currentSubStackMin);
            } else {
                newNode = new Node(element, element);
            }
            newNode.link = head;
            head = newNode;
        }
        print();
    }

    public int pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Underflow");
        Node temp = head;
        head = head.link;
        return temp.data;
    }

    public int min() {
        if (!isEmpty())
            return head.subStackMin;
        throw new IndexOutOfBoundsException("Empty stack error");
    }

    public void print() {
        Node node = head;
        logInLine("*** Print: ");
        while (node.link != null) {
            logInLine(node.data + " (currMin: " + node.subStackMin + ") ==> ");
            node = node.link;
        }
        log("" + node.data);
    }

    private class Node {
        int data;
        int subStackMin;
        Node link;

        Node(int data, int subStackMin) {
            this.data = data;
            this.subStackMin = subStackMin;
            this.link = null;
        }
    }
}
