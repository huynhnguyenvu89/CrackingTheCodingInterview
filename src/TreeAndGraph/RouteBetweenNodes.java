package TreeAndGraph;


import test.VPractive;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes extends VPractive {

    public boolean checkRouteBetweenNode(Graph graph, Node departure, Node destination){
        Node[] allNodes = graph.nodes;
        for (Node n : allNodes) {
            n.visited = false;
        }
        Queue queue = new Queue();
        departure.visited = true;
        queue.enqueue(departure);

        while (!queue.isEmpty()){
            Node node = (Node) queue.dequeue();
            node.visited = true;
            if (node == destination){
                log("Found a route between " + departure.name + " and " + destination.name);
                return true;
            }
            for (Node n : node.adjacent){
                if (n.visited == false) {
                    queue.enqueue(n);
                }
            }
        }
        log("No route found between " + departure.name + " and " + destination.name);
        return false;
    }

    public class Graph {
        public Node[] nodes;
    }

    class Node {
        public String name;
        public Node[] adjacent;
        public boolean visited;

        public Node(String name){
            this.name = name;
            this.adjacent = new Node[]{};
        }

        public void setAdjacent(Node[] adjacent) {
            this.adjacent = adjacent;
        }
    }

    public Graph getTestGraph(){
        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");

        node0.setAdjacent(new Node[]{node1, node4, node5});
        node1.setAdjacent(new Node[]{node3});
        node2.setAdjacent(new Node[]{node1});
        node3.setAdjacent(new Node[]{node2, node4});
        node4.setAdjacent(new Node[]{});
        node5.setAdjacent(new Node[]{});

        Graph graph = new Graph();
        graph.nodes = new Node[]{node0, node1, node2, node3, node4, node5};
        return graph;
    }

    public void testGraph(){
        Graph graph = getTestGraph();
        breadthFirstTraversal(graph);
    }

    public void breadthFirstTraversal(Graph graph){
        Node[] allNodes = graph.nodes;
        for (Node node : allNodes){
            node.visited = false;
        }

        //Begin breadth first search
        Queue queue = new Queue();
        Node root = allNodes[0];
        root.visited = true;
        queue.enqueue(root);

        while (!queue.isEmpty()){
            Node node = (Node) queue.dequeue();
            log("BFS: " + node.name);
            for (Node adjacent : node.adjacent){
                if (adjacent.visited == false) {
                    adjacent.visited = true;
                    queue.enqueue(adjacent);
                }
            }
        }
    }

    class Queue<T> {
        private QueueNode head;
        private QueueNode tail;

        public void enqueue(T data) {
            QueueNode node = new QueueNode(data);
            if (tail != null){
                tail.link = node;
            }
            tail = node;
            if (head == null)
                head = tail;
         }

        public T dequeue(){
            QueueNode temp = head;
            head = head.link;
            return temp.data;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public void print(){
            QueueNode temp = head;
            while (temp.link != null){
                logInLine(temp.data + " ==> ");
                temp = temp.link;
            }
            log(temp.data + ".");
        }

        class QueueNode {
            T data;
            QueueNode link;
            QueueNode(T data){
                this.data = data;
                this.link = null;
            }
        }
    }

    public void testQueue(){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(0);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}
