package TreeAndGraph;
import test.VPractive;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths extends VPractive {

    public void testBinaryTree(){
        BinaryTree binaryTree = getTestBinaryTree();
        binaryTree.print();
    }

    public BinaryTree getTestBinaryTree(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertBalance(1);
        binaryTree.insertBalance(2);
        binaryTree.insertBalance(3);
        binaryTree.insertBalance(4);
        binaryTree.insertBalance(5);
        binaryTree.insertBalance(6);
        binaryTree.insertBalance(7);
        binaryTree.insertBalance(8);
        binaryTree.insertBalance(9);
        binaryTree.insertBalance(10);
        binaryTree.insertBalance(11);
        binaryTree.insertBalance(12);
        binaryTree.insertBalance(13);
        binaryTree.insertBalance(14);
        binaryTree.insertBalance(15);
        return binaryTree;
    }

    public void testQueue(){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }

    public class BinaryTree {
        private Node root;

        BinaryTree(){
            root = null;
        }

        public List<LinkedList<Integer>> getListOfDepths(){
            List<LinkedList<Integer>> res = new LinkedList<>();
            res = getListOfDepths(root, 0, res);
            return res;
        }

        private List<LinkedList<Integer>> getListOfDepths(Node root, int level, List<LinkedList<Integer>> lists){
            if (root == null)
                return null;
            LinkedList<Integer> levelList = null;
            if (level == lists.size()){
                levelList = new LinkedList<>();
                lists.add(levelList);
            } else {
                levelList = lists.get(level);
            }
            levelList.add(root.data);
            getListOfDepths(root.left, level + 1, lists);
            getListOfDepths(root.right, level + 1, lists);
            return lists;
        }

        public void insertBalance(int data) {
            root = insertBalance(this.root, data);
        }

        private Node insertBalance(Node root, int data){
            Queue queue = new Queue();
            queue.enqueue(root);

            while (!queue.isEmpty()){
                Node temp = (Node) queue.dequeue();
                Node newNode = new Node(data);
                if(temp == null){
                    root = newNode;
                    break;
                }
                if (temp.left == null){
                    temp.left = insertBalance(temp.left, data);
                    break;
                } else {
                    queue.enqueue(temp.left);
                }

                if (temp.right == null) {
                    temp.right = insertBalance(temp.right, data);
                    break;
                } else {
                    queue.enqueue(temp.right);
                }

            }
            return root;
        }

        public void print(){
            print("", root);
        }

        private void print(String delimiter, Node root){
            if (root == null)
                return;
            print(delimiter + "     ", root.left);
            log(delimiter + root.data);
            print(delimiter + "     ", root.right);
        }
    }

    class Queue<T> {
        private Node head;
        private Node tail;

        Queue(){
            head = tail = null;
        }

        public void enqueue(T data) {
            Node newNode = new Node(data);
            if (tail != null){
                tail.link = newNode;
            }
            tail = newNode;
            if (head == null){
                head = tail;
            }
        }

        public boolean isEmpty(){
            return head == null;
        }

        public T dequeue(){
            Node temp = head;
            head = head.link;
            return temp.data;
        }

        public void print(){
            Node temp = head;
            while (temp.link != null){
                logInLine(temp.data + " ==> ");
                temp = temp.link;
            }
            log(temp.data + ".");
        }

        class Node {
            T data;
            Node link;
            Node (T data) {
                this.data = data;
                link = null;
            }
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
            left = right = null;
        }
    }
}
