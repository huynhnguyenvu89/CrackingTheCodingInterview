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
            System.out.print("*** Linked list print: ");
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
            }
            node = node.next;
        }
        if (!hashMap.containsKey(node.data)){
            Node newNode = new Node(node.data);
            current.next = newNode;
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

        while (headNode.next != null){
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
            kNode = kNode.next;
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
        int buff = 0;

        while (fastNode.next != null) {
            if (buff == 0) {
                buff += 1;
            } else {
                buff = 0;
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
     * or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x.
     * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left
     * and right partition.
     *
     * Example:
     * 3 -> 5 -> 8 -> 5 -> 9 -> 2 -> 1 (partition = 5)
     * 3 -> 1 -> 2 -> 9 -> 5 -> 5 -> 8
     * @param x
     */
    public void partition(int x){

    }
}
