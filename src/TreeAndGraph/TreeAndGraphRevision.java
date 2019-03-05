package TreeAndGraph;

import test.VPractive;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TreeAndGraphRevision extends VPractive {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static void print(String delimiter, Node root){
        if (root == null)
            return;
        print(delimiter + "     ", root.left);
        VPractive.logd(delimiter + root.data);
        print(delimiter + "     ", root.right);
    }

    /**
     * Binary Search Tree Implementation
     * - Insert
     * - Remove
     * - Search
     * - Find min and max
     */
    class BinarySearchTree {
        private Node root;

        public void insert(int data) {
            root = insert(root, data);
        }

        private Node insert(Node root, int data){
            Node node = new Node(data);
            if (root == null){
                root = node;
            } else if (data <= root.data){
                root.left = insert(root.left, data);
            } else if (data > root.data){
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
            if (data == root.data){
                return true;
            } else if (data < root.data) {
                return search(root.left, data);
            } else {
                return search(root.right, data);
            }
        }

        public void remove(int data){
            root = remove(root, data);
        }

        private Node remove(Node root, int data){
            if (root == null)
                return null;

            if (data < root.data){
                root.left = remove(root.left, data);
            } else if (data > root.data){
                root.right = remove(root.right, data);
            } if (data == root.data) { //Found the node to be deleted
                //If no child
                if (root.left == null && root.right == null){
                    log("Remove no child: " + root.data);
                    root = null;
                }//If one child exists
                else if (root.left != null && root.right == null){
                    log("Remove 1 child left: " + root.data);
                    root = root.left;
                } else if (root.right != null && root.left == null){
                    log("Remove 1 child right: " + root.data);
                    root = root.right;
                }//If both children present
                else if (root.right != null && root.left != null){
                    log("Remove 2 children: " + root.data);
                    Node min = findMin(root.right);
                    root.data = min.data;
                    root.right = remove(min, min.data);
                }
            }
            return root;
        }

        private int findMin(){
            Node res = findMin(root);
            if (res == null)
                return -1;
            return res.data;
        }

        private Node findMin(Node root){
            if (root == null)
                return null;
            if (root.left == null)
                return root;
            return findMin(root.left);
        }

        public int findMax(){
            Node res = findMax(root);
            if (res == null)
                return -1;
            return res.data;
        }

        private Node findMax(Node root){
            if (root == null){
                return null;
            }
            if (root.right == null){
                return root;
            }
            return findMax(root.right);
        }

        public void print(){
            TreeAndGraphRevision.print("", root);
        }
    }

    public void testBSTImplementation(){
        BinarySearchTree bst = new BinarySearchTree();
        log("Test BST Insertion");
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(1);
        bst.insert(10);
        bst.insert(3);
        bst.insert(2);
        bst.insert(7);

        bst.print();
        log("Search 2: " + bst.search(2));
        log("Search 7: " + bst.search(7));
        log("Search 22: " + bst.search(22));

        bst.remove(7);
        bst.print();
        bst.remove(1);
        bst.print();
        bst.remove(5);
        bst.print();
        bst.remove(22);
        bst.print();

        log("Find min " + bst.findMin());
        log("Find max " + bst.findMax());
    }


    /**
     * Find height of a Binary Tree
     */
    private Node getTestBinaryTree(){
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

    public void testFindHeightBinaryTree(){
        Node root = getTestBinaryTree();
        print("", root);
        log("Binary Tree height: " + getHeight(root));
    }

    private int getHeight(Node root){
        if (root == null)
            return -1;
        int leftHeight = 1 + getHeight(root.left);
        int rightHeight = 1 + getHeight(root.right);
        int height = Math.max(leftHeight, rightHeight);
//        log("Check: data " + root.data + " left " + leftHeight + " right " + rightHeight + " max " + height);
        return height;
    }

    /**
     * Given a sort (increasing order) array with unique integer elements,
     * write an algorithm to create a binary search tree with minimal height
     */
    public void testMinimalTree(){
        int[] input = new int[]{2, 4, 5, 7, 8, 9, 12, 14, 15, 17, 18, 19, 20, 21, 26};
        log("Test Minimal Tree " + input.length);
        Node root = getMinimalTree(0, input.length - 1, input);
        print("", root);
    }

    private Node getMinimalTree(int start, int end, int[] data){
        if (end - start < 0)
            return null;
        int mid = (end + start) / 2;
        log("mid " + mid + " start " + start + " end " + end);
        Node node = new Node(data[mid]);
        node.left = getMinimalTree(start, mid - 1, data);
        node.right = getMinimalTree(mid + 1, end, data);
        return node;
    }

    /**
     * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */
    public boolean checkRoute(GraphNode departure, GraphNode destination) {
        HashSet<GraphNode> set = new HashSet();
        Queue queue = new Queue();
        queue.enqueue(departure);
        boolean res = false;

        while (!queue.isEmpty()) {
            GraphNode node = (GraphNode) queue.dequeue();
            log("Check adjacent: " + node.data);
            for (GraphNode adjacent : node.adjacent){
                if(adjacent == destination){
                    res = true;
                }
                if (!set.contains(adjacent)) {
                    queue.enqueue(adjacent);
                    set.add(adjacent);
                }
            }
        }
        return res;
    }

    public void testRouteBetweenNode(){
        Graph graph = getTestGraph();
        log("Check route between node 0 & 2: " + checkRoute(graph.nodes[0], graph.nodes[2]));
        log("Check route between node 2 & 5: " + checkRoute(graph.nodes[2], graph.nodes[5]));
    }

    class Graph {
        GraphNode[] nodes;
    }

    class GraphNode {
        int data;
        GraphNode[] adjacent;

        GraphNode(int data){
            this.data = data;
        }

        public void setAdjacent(GraphNode[] adjacent){
            this.adjacent = adjacent;
        }
    }

    private Graph getTestGraph(){
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        node0.setAdjacent(new GraphNode[]{node1, node4, node5});
        node1.setAdjacent(new GraphNode[]{node3});
        node2.setAdjacent(new GraphNode[]{node1});
        node3.setAdjacent(new GraphNode[]{node2, node4});
        node4.setAdjacent(new GraphNode[]{});
        node5.setAdjacent(new GraphNode[]{});

        Graph graph = new Graph();
        graph.nodes = new GraphNode[]{node0, node1, node2, node3, node4, node5};
        return graph;
    }

    private void printGraph(Graph graph){
        if (graph == null)
            return;
        log("_Print Graph Breadth First Traversal_");
        GraphNode[] nodes = graph.nodes;
        HashSet<GraphNode> visitedNodes = new HashSet<>();
        Queue queue = new Queue();
        queue.enqueue(nodes[0]);

        while (!queue.isEmpty()){
            GraphNode node = (GraphNode) queue.dequeue();
            for (GraphNode adjacent: node.adjacent) {
                if (!visitedNodes.contains(adjacent)){
                    log("Graph node: " + adjacent.data);
                    queue.enqueue(adjacent);
                    visitedNodes.add(node);
                }
            }
        }
    }

    public void testGraph(){
        Graph graph = getTestGraph();
        printGraph(graph);
    }

    class Queue<T> {

        class Node {
            T data;
            Node link;
            Node(T data){this.data = data;}
        }
        private Node head;
        private Node tail;

        public boolean isEmpty(){
            return head == null;
        }

        public T dequeue(){
            Node temp = head;
            head = head.link;
            return temp.data;
        }

        public void enqueue(T data){
            Node node = new Node(data);
            if (tail != null) {
                tail.link = node;
            }
            tail = node;
            if (head == null){
                head = tail;
            }
        }
    }

    /**
     * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.
     * (e.g., if you have a tree with depth D, you'll have D linked lists).
     */
    public void testListOfDepth(){
        Node root = getTestBinaryTree();
        List<LinkedList<Node>> listOfDepth = new LinkedList<>();
        listOfDepth = getListOfDepth(root, listOfDepth, 0);
        if (listOfDepth == null)
            return;
        //Print result
        print("", root);
        for (int i = 0; i < listOfDepth.size(); i ++) {
            LinkedList<Node> list = listOfDepth.get(i);
            String res = "";
            for (Node node : list){
                res = res + (node.data + " ");
            }
            log("Level " + i + ": " + res);
        }
    }

    private List<LinkedList<Node>> getListOfDepth(Node root, List<LinkedList<Node>> lists, int level){
        if (lists == null || root == null)
            return null;
        LinkedList<Node> currentLevel;
        if (lists.size() == level){
            currentLevel = new LinkedList<>();
            lists.add(currentLevel);
        } else {
            currentLevel = lists.get(level);
        }
        currentLevel.add(root);
        getListOfDepth(root.left, lists, level + 1);
        getListOfDepth(root.right, lists, level + 1);

        return lists;
    }

    /**
     * Implement a function to check if a binary tree is balanced. For the purpose of this question,
     * a balanced tree is defined to be a tree such that the heights of the two sub-trees of any
     * node never differ more than one.
     */

    private Node getTestBalancedBinaryTree(){
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
        six.left = eight;
        seven.right = nine;
        return one;
    }

    public void testTreeBalanced(){
        Node root = getTestBinaryTree();
        print("", root);
        log("Check tree balance " + isTreeBalanced(root));
        Node balancedRoot = getTestBalancedBinaryTree();
        print("", balancedRoot);
        log("Check tree balance " + isTreeBalanced(balancedRoot));
    }

    private int ERROR_CODE = Integer.MIN_VALUE;

    private boolean isTreeBalanced(Node root){
        return getTreeHeight(root) != ERROR_CODE;
    }

    private int getTreeHeight(Node root) {
        if (root == null)
            return -1;

        int leftHeight = getTreeHeight(root.left) + 1;
        if (leftHeight == ERROR_CODE)
            return ERROR_CODE;
        int rightHeight = getTreeHeight(root.right) + 1;
        if (rightHeight == ERROR_CODE)
            return ERROR_CODE;

        int diff = Math.abs(leftHeight - rightHeight);
        log("Node " + root.data + " left " + leftHeight + " right " + rightHeight + " diff " + diff);
        if (diff > 1) {
            log("Error " + root.data);
            return ERROR_CODE;
        } else {
            return Math.max(leftHeight, rightHeight);
        }
    }
}
