package LinkedList;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList<T> {
    private Node head;

    public LinkedList(){ }

    public LinkedList(Node head) {
        this.head = head;
    }

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

    private class Node<T> {
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

    private void print(Node head) {
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
            return (T) kNode.data;
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

    /**
     * Sum Lists: You have 2 numbers represented by a LinkedList, where each node contains a single digit.
     * The digits are stored in reversed order, such that the 1's digit is at the head of the list.
     * Write a function that adds the two numbers and returns the sum as a LinkedList.
     *
     * Example:
     * Input    (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295 = 912
     * Output   (2 -> 1 -> 9)
     */
    public LinkedList sumReversedLists(LinkedList first, LinkedList second){
        LinkedList res = null;
        Node resNode = null;
        Node firstHead = first.head;
        Node secondHead = second.head;
        int carryValue =0, firstValue, secondValue;

        while (firstHead != null || secondHead != null) {
            if (firstHead == null)
                firstValue = 0;
            else
                firstValue = (Integer) firstHead.data;
            if (secondHead == null)
                secondValue = 0;
            else
                secondValue = (Integer) secondHead.data;

            int sumValue = carryValue + firstValue + secondValue;
            carryValue = sumValue / 10;
            int placeValue = sumValue % 10;

            Node<Integer> newNode = new Node(placeValue);
            if (res == null) {
                res = new LinkedList();
                resNode = newNode;
                res.head = resNode;
            } else {
                resNode.next = newNode;
                resNode = resNode.next;
            }

            if (firstHead != null) firstHead = firstHead.next;
            if (secondHead != null) secondHead = secondHead.next;
        }

        System.out.println("-" + carryValue);
        if (carryValue > 0) {
            Node<Integer> resTail = new Node(carryValue);
            resNode.next = resTail;
        }

        return res;
    }

    /**
     * Follow up: Suppose the digits are stored in forward order. Repeat the problem above.
     *
     * Example:
     * Input    (6 -> 1 -> 7) + (2 -> 9 -> 5). That is 617 + 295 = 912
     * Output   (9 -> 1 -> 2)
     * @param first
     * @param second
     * @return
     */
    public static LinkedList sumForwardLists(LinkedList first, LinkedList second){
        LinkedList res = new LinkedList();
        return res;
    }

    /**
     * Implement a function to check if a LinkedList is a palindrome.
     * A palindrome is a sequence that reads the same backward as forward, e.g., madam or nurses run.
     *
     * @return true if it's a palindrome, false otherwise.
     */
    public boolean isPalindrome(){
        Node currHead = head;
        Node reverseHead = null;
        int counter = 0;

        while (currHead != null){
            Node newNode = new Node(currHead.data);
            if (reverseHead == null){
                reverseHead = newNode;
                reverseHead.next = null;
            } else {
                newNode.next = reverseHead;
                reverseHead = newNode;
            }
            counter ++;
            currHead = currHead.next;
        }
        currHead = head;

        //Only need to check half of the linked list size, since they're reverses.
        counter = counter / 2;
        for (int i = 0; i < counter; i++) {
            if (reverseHead.data != currHead.data)
                return false;
            currHead = currHead.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }

    /**
     * Intersection: Given 2 singly linked lists, determine if the two lists intersect.
     * Return the intersecting node's value.
     * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked
     * list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
     * @param input
     * @return
     */
    public T checkIntersection(LinkedList input){
        Node firstHead = head;
        Node secondHead = input.head;
        HashMap hashMap = new HashMap();

        while (firstHead != null) {
            hashMap.put(firstHead, true);
            firstHead = firstHead.next;
        }

        while (secondHead != null) {
            if (hashMap.containsKey(secondHead))
                return (T) secondHead.data;
            secondHead = secondHead.next;
        }

        return null;
    }

    /**
     * TEST ONLY: Create an intersecting Linked List for testing purpose
     * Mark as Ignore, not to use anywhere else.
     *
     * @see LinkedList#checkIntersection(LinkedList)
     */
    @Ignore
    public void markIntersectingLinkedLists(LinkedList intersectingList){
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = intersectingList.head;
    }

    /**
     * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of
     * the loop.
     * Definition: A circular linked list is a (corrupt) linked list in which a node's next pointer points to an earlier
     * node, so as to make a loop in the linked list.
     * Example:
     * A -> B -> C -> D -> E -> C (the same C as earlier)
     *
     * @return
     */
    public T loopDetection(Node head){
        Node corruptedNode = null;
        Node curr = head;
        HashMap hashMap = new HashMap();
        System.out.println("Head node: " + head + "-" + curr);

        while (curr != null) {
            if (hashMap.containsKey(curr)) {
                System.out.println("Found corrupting node: " + curr.data);
                corruptedNode = curr;
                break;
            } else {
                System.out.println("1 Add to map: " + curr);
                hashMap.put(curr, true);
                System.out.println("2 Add to map: " + hashMap.containsKey(curr));
            }
            curr = curr.next;
        }

        return corruptedNode == null ? null : (T) corruptedNode.data;
    }

    /**
     * TEST ONLY: Create an circular/corrupted Linked List by forcing the tail node of the second LinkedList points to
     * the tail of the first one. Return a corrupted circular LinkedList.
     * Mark as Ignore, not to use anywhere else.
     *
     * @see LinkedList#loopDetection(Node)
     */
    @Ignore
    public void createCircularLinkedList(LinkedList firstHalf, LinkedList secondHalf){
        Node firstHead = firstHalf.head;
        Node firstTail = null;
        Node secondHead = secondHalf.head;
        Node secondTail = null;

        while (firstHead != null) {
            firstTail = firstHead;
            System.out.println("Adding " + firstTail);
            add((T) firstTail.data);
            firstHead = firstHead.next;
        }
        while (secondHead != null){
            secondTail = secondHead;
            System.out.println("Adding " + secondTail);
            add((T) secondTail);
            secondHead = secondHead.next;
        }
        secondHead = secondHalf.head;
        secondTail.next = secondHead;
        System.out.println("Corrupting " + secondTail + " points to " + secondTail.next + " " + secondTail.next.next);

        System.out.println("LoopDetection: " + head + "-"+ loopDetection(head));
    }
}
