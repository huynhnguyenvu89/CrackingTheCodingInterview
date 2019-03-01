package TreeAndGraph;

import test.VPractive;

public class BinarySearchTree extends VPractive {

    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data){
        if (root == null){
            root = new Node(data);
        } else if (data <= root.data){
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public boolean search(int data){
        return search(root, data);
    }

    private boolean search(Node root, int data){
        if (root == null)
            return false;
        if (root.data == data){
            return true;
        } else if (data < root.data){
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    public boolean remove(int data){
        log("Deleting " + data + " from BST");
        print();

        print();
        return false;
    }

    private void remove(Node root, int data){
        if (root == null){
            return;
        }

    }

    public int findMinIteratively(){
        return findMinIteratively(root);
    }

    private int findMinIteratively(Node root){
        if (root == null)
            return -1;
        while (root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public int findMinRecursively(){
        return findMinRecursively(root);
    }

    private int findMinRecursively(Node root){
        if (root == null)
            return -1;
        if (root.left == null)
            return root.data;
        return findMinRecursively(root.left);
    }

    public int findMaxIteratively(){
        return findMaxIteratively(root);
    }

    private int findMaxIteratively(Node root){
        if (root == null){
            return -1;
        }
        while (root.right != null){
            root = root.right;
        }
        return root.data;
    }

    public int findMaxRecursively(){
        return findMaxRecursively(root);
    }

    private int findMaxRecursively(Node root){
        if (root == null)
            return -1;
        if (root.right== null)
            return root.data;
        return findMaxRecursively(root.right);
    }

    public void print(){
        if (root == null)
            return;
        printAscending("", root);
    }

    private void printAscending(String delimiter, Node root){
        if (root != null){
            printAscending(delimiter + "     ", root.left);
            log(delimiter + root.data );
            printAscending(delimiter + "     ", root.right);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            right = left = null;
        }
    }
}
