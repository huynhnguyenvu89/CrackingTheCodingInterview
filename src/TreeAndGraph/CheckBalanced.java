package TreeAndGraph;

import test.VPractive;

/**
 * Implement a function to check if a binary tree is balanced.
 */
public class CheckBalanced extends VPractive {

    public int getHeight (Node root) {
        if (root == null)
            return -1;
        int leftHeight = 1 + getHeight(root.left);
        int rightHeight = 1+ getHeight(root.right);
        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(Node root){
        if (root == null)
            return true;

        int leftHeight = 1 + getHeight(root.left);
        int rightHeight = 1 + getHeight(root.right);
        int diff = leftHeight - rightHeight;
        log("Check " + root.data + " left " + leftHeight + " right " + rightHeight);

        if(Math.abs(diff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public Node getUnbalancedBinaryTree(){

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node (4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node (7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        one.left = two;
        one.right = four;
        two.left = three;
        three.left = five;
        four.left = six;
        four.right = seven;
        six.left = eight;
        eight.left = nine;
        return one;
    }

    public Node getBalancedBinaryTree(){

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node (4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node (7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        one.left = two;
        one.right = four;
        two.left = three;
        two.right = five;
        four.left = six;
        four.right = seven;
        three.left = eight;
        five.left = nine;
        return one;
    }

    public void print(Node root) {
        if (root == null)
            return;
        print("", root);
    }

    public void print(String delimiter, Node root) {
        if (root == null)
            return;
        print(delimiter + "     ",root.left);
        log(delimiter + root.data);
        print(delimiter + "     ", root.right);
    }

    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
