package LinkedList;

import java.util.HashMap;

public class LinkedList<T> {
    private Node head;

    public LinkedList(){ }

    public LinkedList(T data) {
        head = new Node(data);
        head.next = null;
    }

    public void add(T data) {
        if (data == null)
            return;
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node node = head;
        Node newNode = new Node(data);
        while (node.next != null)
            node = node.next;
        node.next = newNode;
    }

    public void remove(T data) {
        if (head == null || data == null)
            return;
        if (head.data == data)
            head = head.next;

        Node node = head;
        Node prev = null;
        while (node.next != null) {
            prev = node;
            if (node.next.data == data) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        if (node.data == data) {
            prev.next = null;
        }
    }

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public void print() {
        if (head != null) {
            System.out.println("*** Linked list print starts ***");
            Node node = head;
            while (node.next != null) {
                System.out.println("" + node.data);
                node = node.next;
            }
            System.out.println("" + node.data);
            System.out.println("*** Linked list print ends ***");
        }
    }

    public void print(Node head) {
        System.out.println("*** Linked list print test node starts ***");
        if (head != null) {
            Node node = head;
            while (node.next != null) {
                System.out.println("" + node.data);
                node = node.next;
            }
            System.out.println("" + node.data);
            System.out.println("*** Linked list print test node ends ***");
        }
    }
    /**
     * Remove the subsequent duplicates in a given unsorted LinkedList. For example:
     * In:      1 -> 1 -> 5 -> 3 -> 5 -> 5 -> 2 -> 9 -> 3
     * Out:     1 -> 5 -> 3 -> 2 -> 9
     *
     */
    public void removeSubsequentDuplicates(){
        if (head == null)
            throw new IllegalArgumentException("Input must not be null");
        //If only 1 element found, no need to check for duplicate
        if (head.next == null)
            return;
        HashMap hashMap = new HashMap<T, Boolean>();
        Node node = head;
        Node newHead = null;
        Node current = null;

        while (node.next != null) {
            if (!hashMap.containsKey(node.data)) {
                hashMap.put(node.data, true);
                if (newHead == null) {
                    newHead = new Node(node.data);
                    current = newHead;
                } else {
                    Node newNode = new Node(node.data);
                    current.next = newNode;
                    current = newNode;
                }
            } else {
                System.out.println("Found duplicate " + node.data);
            }
            node = node.next;
        }
        if (!hashMap.containsKey(node.data)){
            Node newNode = new Node(node.data);
            current.next = newNode;
        }
        head = newHead;
    }
}
