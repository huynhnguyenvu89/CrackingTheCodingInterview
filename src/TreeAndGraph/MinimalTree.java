package TreeAndGraph;

import test.VPractive;

/**
 *
 */
public class MinimalTree extends VPractive {
    private Node root;

    public void insert(int[] data){
        root = insertMinimalTree(root, data, 0, data.length - 1);
    }

    private Node insertMinimalTree(Node root, int[] data, int start, int end) {
        if (end < start)
            return null;
        int mid = (end + start) / 2;
        root = new Node(data[mid]);
        root.left = insertMinimalTree(root.left, data, start, mid - 1);
        root.right = insertMinimalTree(root.right, data, mid + 1, end);
        return root;
    }

    public void print(){
        print("", root);
        log("Print root " + (root == null));
    }

    private void print(String delimiter, Node root){
        if (root != null){
            print(delimiter + "     ", root.right);
            log(delimiter + root.data);
            print(delimiter + "     ", root.left);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
}
