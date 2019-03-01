package test;

import TreeAndGraph.BinarySearchTree;

public class TreeAndGraphTest extends VPractive{

    public TreeAndGraphTest(){
    }

    public void runTestSuite(boolean active){
        if (!active)
            return;
        testBinarySearchTree(true);
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
        binarySearchTree.insert(2);
        binarySearchTree.insert(22);
        binarySearchTree.print();

        log("Search 2: " + binarySearchTree.search(2));
        log("Search 25: " + binarySearchTree.search(25));
        log("Search 17: " + binarySearchTree.search(17));
        log("Search 23: " + binarySearchTree.search(23));

        log("Find min iteratively: " + binarySearchTree.findMinIteratively());
        log("Find min recursively: " + binarySearchTree.findMinRecursively());
        log("Find max iteratively: " + binarySearchTree.findMaxIteratively());
        log("Find max recursively: " + binarySearchTree.findMaxRecursively());


    }

}
