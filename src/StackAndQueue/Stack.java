package StackAndQueue;

import test.MyLog;
import test.VPractive;

public class Stack<T> extends VPractive {

    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    public Stack(){
        head = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public void push(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void pop(){
        if (head == null) {
            throw new IndexOutOfBoundsException("Stack underflow error");
        }
        Node temp = head.next;
        head = head.next;
    }

    public T peek(){
        if (head == null) {
            throw new IndexOutOfBoundsException("Stack underflow error");
        }
        Node temp = head.next;
        head = head.next;
        return temp.data;
    }

    public void print(){
        Node node = head;
        log("*** Stack linked list print: ");
        while (node.next != null){
            logInLine(node.data + " ==> ");
            node = node.next;
        }
        log(node.data + "");
    }
}
