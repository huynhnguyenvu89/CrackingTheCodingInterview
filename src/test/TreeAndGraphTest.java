package test;

import TreeAndGraph.*;

import java.util.LinkedList;
import java.util.List;

public class TreeAndGraphTest extends VPractive{

    public TreeAndGraphTest(){ }

    public void runTestSuite(boolean active){
        if (!active)
            return;
        testBinarySearchTree(false);
        testMinimalTree(false);
        testRouteBetweenNodes(false);
        testListOfDepth(false);
        testCheckBalanced(true);
    }

    private void testCheckBalanced(boolean active){
        if (!active)
            return;

        CheckBalanced checkBalanced = new CheckBalanced();
        CheckBalanced.Node balancedNode = checkBalanced.getBalancedBinaryTree();
        checkBalanced.print(balancedNode);
        log("Check balanced: " + checkBalanced.isBalanced(balancedNode));
        CheckBalanced.Node unbalancedNode = checkBalanced.getUnbalancedBinaryTree();
        checkBalanced.print(unbalancedNode);
        log("Check balanced: " + checkBalanced.isBalanced(unbalancedNode));
    }

    private void testListOfDepth(boolean active){
        if (!active)
            return;

        ListOfDepths listOfDepths = new ListOfDepths();
        listOfDepths.testQueue();
        ListOfDepths.BinaryTree binaryTree = listOfDepths.getTestBinaryTree();
        binaryTree.print();
        List<LinkedList<Integer>> result = binaryTree.getListOfDepths();
        for (LinkedList list: result){
            logInLine("<< ");
            for (int i = 0; i < list.size(); i ++){
                logInLine(list.get(i) + " --> ");
            }
            log(" >>");
        }
    }

    private void testRouteBetweenNodes(boolean active){
        if (!active)
            return;
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        RouteBetweenNodes.Graph graph = routeBetweenNodes.getTestGraph();
        routeBetweenNodes.checkRouteBetweenNode(graph, graph.nodes[0], graph.nodes[3]);
        routeBetweenNodes.checkRouteBetweenNode(graph, graph.nodes[2], graph.nodes[5]);
    }

    private void testMinimalTree(boolean active){
        if (!active)
            return;
        MinimalTree minimalTree = new MinimalTree();
        int[] input = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        minimalTree.insert(input);
        minimalTree.print();
    }

    //15, 10, 20, 8, 12, 17, 25
    private void testBinarySearchTree(boolean active){
        if (!active)
            return;

        log("Inserting 15, 10, 20, 8, 12, 17, 25");
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(20);
        binarySearchTree.insert(8);
        binarySearchTree.insert(12);
        binarySearchTree.insert(17);
        binarySearchTree.insert(25);
        binarySearchTree.print();

        log("Search 2: " + binarySearchTree.search(2));
        log("Search 25: " + binarySearchTree.search(25));
        log("Search 17: " + binarySearchTree.search(17));
        log("Search 23: " + binarySearchTree.search(23));

        log("Find min iteratively: " + binarySearchTree.findMinIteratively());
        log("Find min recursively: " + binarySearchTree.findMinRecursively());
        log("Find max iteratively: " + binarySearchTree.findMaxIteratively());
        log("Find max recursively: " + binarySearchTree.findMaxRecursively());

        binarySearchTree.insert(2);
        binarySearchTree.insert(22);
        binarySearchTree.print();
        log("Deleting 2");
        binarySearchTree.remove(2);
        binarySearchTree.print();
        log("Deleting 15");
        binarySearchTree.remove(15);
        binarySearchTree.print();
    }

}
