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

        Node node = head;
        Node prev = null;
        while (node != null) {
            if (node.data == data) {
                if (prev == null){
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
            }
            prev = node;
            node = node.next;
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
            System.out.print("***>> ");
            Node node = head;
            while (node.next != null) {
                System.out.print("" + node.data + " -> ");
                node = node.next;
            }
            System.out.println("" + node.data);
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

        while (node != null) {
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
            }
            node = node.next;
        }
        head = newHead;
    }

    /**
     * Returns the Kth node to last in Linked List,
     * If given K is larger then Linked List size, then return null
     *
     * @param k
     * @return
     */
    public T returnKthToLast(int k){
        Node headNode = head;

        int kPtr = 0;
        Node kNode = null;

        while (headNode != null){
            if (k == 0) {
                kNode = headNode;
            } else if (kPtr == k) {
                if (kNode == null) {
                    kNode = head;
                } else {
                    kNode = kNode.next;
                }
            } else {
                kPtr += 1;
            }
            headNode= headNode.next;
        }

        if (kNode != null){
            return kNode.data;
        } else {
            return null;
        }
    }

    /**
     * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
     * not necessarily the exact middle) of a singly linked list
     *
     * Example 1:
     * 0 -> 1 -> 2 -> 3 -> 4 -> 0
     * 0 -> 1 -> 3 -> 4 -> 0
     *
     * Example 2:
     * 0 -> 1 -> 2 -> 3 -> 4
     * 0 -> 1 -> 3 -> 4
     *
     * Example 3:
     * 0 -> 1
     * 0 -> 1
     */
    public void deleteMiddleNode(){
        Node fastNode = head;
        Node slowNode = null;
        int counter = 0;

        while (fastNode.next != null) {
            if (counter == 0) {
                counter = 1;
            } else {
                counter = 0;
                if (slowNode == null) {
                    slowNode = head;
                } else {
                    slowNode = slowNode.next;
                }
            }

            fastNode = fastNode.next;
        }
        if (slowNode == null)
            return;

        slowNode.next = slowNode.next.next;
    }

    /**
     * Partition a LinkedList around a value x, such that all nodes less than x come before all nodes greater than
     * or equal to x. If x is contained within the list, the values of x need to be after the elements less than x.
     *
     * Example:
     * 2 -> 3 -> 5 -> 8 -> 5 -> 9 -> 2 -> 1 -> 1 (partition = 5)
     * 1 -> 1 -> 2 -> 3 -> 2 -> 5 -> 8 -> 5 -> 9
     * @param x
     */
    public void partition(int x){
        Node curr = head;
        Node tail = head;

        while (curr != null) {
            //Save curr.next to assign to curr later, avoid infinite loop.
            Node next = curr.next;
            if ((Integer) curr.data < x) {
                //Put curr Node to head position, update head
                curr.next = head;
                head = curr;
            } else {
                //Put curr Node to tail position, update tail
                tail.next = curr;
                tail = curr;
            }
            curr = next;
        }
        tail.next = null;

    }

    /**
     * Reverse all elements in a Linked List.
     */
    public void reverseLinkedList(){
        Node curr = head;
        Node tail = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = head;
            head = curr;
            curr = next;
        }
        tail.next = null;
    }
}
