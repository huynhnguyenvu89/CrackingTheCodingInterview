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

    public void remove(int data){
        remove(root, data);
    }

    private Node remove(Node root, int data){
        if (root == null){
            log("Root is null");
        } else if (data < root.data){
            root.left = remove(root.left, data);
        } else if (data > root.data){
            root.right = remove(root.right, data);
        } else {
            //Case 1: If there is no subtree
            if (root.right == null && root.left == null){
                root = null;
            }
            //Case 2: If there is only 1 subtree
            else if (root.right == null) {
                root = root.left;
            } else if (root.left == null){
                root = root.right;
            }
            //Case 3: If there are 2 subtrees
            else {
                //Find the minimum value in its right sub tree
                Node minSubTree = findMin(root.right);
                //Replace root data with the min value
                root.data = minSubTree.data;
                //Recursively delete the min node from the right sub-tree
                root.right = remove(root.right, minSubTree.data);
            }
        }

        return root;
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

    private Node findMin(Node root){
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return findMin(root.left);
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
