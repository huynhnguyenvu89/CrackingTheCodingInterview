package LinkedList;

public class LinkedList<T> {
    private Node head;

    public LinkedList(T data) {
        head = new Node(data);
        head.next = null;
    }

    public void add(T data) {
        if (head == null || data == null)
            return;
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
}
