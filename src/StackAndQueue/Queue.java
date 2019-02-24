package StackAndQueue;

import test.MyLog;
import test.VPractive;

public class Queue<T> extends VPractive {
    private Node head;
    private Node tail;

    private class Node {
        T data;
        Node link;
        Node(T data) {
            this.data = data;
            this.link = null;
        }
    }

    public Queue(){
        tail = head = null;
    }

    public void add(T data){
        Node newNode = new Node(data);
        if (tail != null) {
            tail.link = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
    }

    public T remove(){
        Node temp = head;
        head = head.link;
        return temp.data;
    }

    public T peek(){
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        Node curr = head;
        log("*** Queue Print:");
        while (curr.link != null) {
            logInLine(curr.data + " ==> ");
            curr = curr.link;
        }
        log(curr.data + "");
    }
}
