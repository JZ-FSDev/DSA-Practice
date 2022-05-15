import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Graph {

    private ArrayList<ArrayList<Integer>> adjacencyList;
    private ArrayList<ArrayList<Boolean>> adjacencyMatrix;
    private int numVertices;

    /**
     * Creates a new graph of numVertices.  Each vertex number corresponds to the
     * index of the array (Vertices are numbers from 0 to n-1).
     * Stores the edge information in both an adjacency list and matrix.
     * 
     * @param numVertices The number of vertices to instantiate the new graph as.
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<ArrayList<Integer>>();
        adjacencyMatrix = new ArrayList<ArrayList<Boolean>>();

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<Integer>());
            adjacencyMatrix.add(new ArrayList<Boolean>());
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix.get(i).add(false);
            }
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(9);

        graph.addEdge(8, 2);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(3, 1);
        graph.addEdge(6, 1);
        graph.addEdge(0, 6);
        graph.addEdge(1, 0);
        graph.addEdge(5, 2);
        graph.addEdge(7, 5);
        graph.addEdge(7, 1);

        graph.print();
        graph.dftRecursivePrint(1);
        graph.depthFirstTraversalIterativePrint(1);
        // graph.breadthFirstTraversalPrint(0);
        // graph.depthFirstTraversalIterativePrint(2);
        // graph.breadthFirstTraversalPrint(6);
    }

    /**
     * Adds a new edge between vertices from and to.
     * 
     * @param from One of the two vertices to be connected.
     * @param to   The other of the two vertices to be connected.
     */
    public void addEdge(int from, int to) {
        orderedInsert(adjacencyList.get(from), to);
        orderedInsert(adjacencyList.get(to), from);

        adjacencyMatrix.get(from).set(to, true);
        adjacencyMatrix.get(to).set(from, true);
    }

    /**
     * Inserts the given item into the given list in an ordered manner.
     * 
     * @param list The ArrayList of ints to be inserted into.
     * @param item The int to insert into the list.
     */
    private void orderedInsert(ArrayList<Integer> list, int item) {
        int index = -1;
        if (list.size() > 0) {
            for (int i = 0; i < list.size() && index == -1; i++) {
                if (list.get(i) > item) {
                    index = i;
                }
            }
            if (index == -1) {
                list.add(item);
            } else {
                list.add(index, item);
            }
        } else {
            list.add(item);
        }
    }

    /**
     * Performs a depth first search from the given vertex iteratively
     * and returns the previous vertices of each vertex visited as an array
     * in the order they were visited during the search. Prints out the
     * order the nodes were visited.
     * 
     * @param vertex The vertex to perform the depth first search from.
     * @return Previous vertices of each vertex an array in the order they were
     *         visited during the search.
     */
    public int[] depthFirstTraversalIterativePrint(int vertex) {
        System.out.println();
        ArrayList<Integer> verticesVisited = new ArrayList<Integer>();
        int[] prev = null;
        if (vertex < numVertices && vertex >= 0) {
            System.out.print("Depth First Traversal: ");
            Stack<Integer> stack = new Stack<Integer>();
            prev = new int[numVertices];
            for (int i = 0; i < prev.length; i++) {
                prev[i] = -1;
            }
            stack.push(vertex);
            verticesVisited.add(vertex);
            System.out.print(vertex);
            while (!stack.isEmpty()) {
                boolean added = false;
                int prevPeek = stack.peek();
                for (int i = 0; i < adjacencyList.get(prevPeek).size() && !added; i++) {
                    if (!exists(verticesVisited, adjacencyList.get(prevPeek).get(i))) {
                        prev[adjacencyList.get(prevPeek).get(i)] = prevPeek;
                        stack.push(adjacencyList.get(prevPeek).get(i));
                        verticesVisited.add(stack.peek());
                        System.out.print(stack.peek());
                        added = true;
                    }
                }
                if (!added) {
                    stack.pop();
                }
            }
            System.out.println();
        }
        return prev;
    }

    /**
     * Call the helper method to perform a depth first search from the given 
     * vertex recursively and prints out the order the nodes were visited.
     * 
     * @param vertex The vertex to perform the depth first search from.
     */
    public void dftRecursivePrint(int vertex) {
        boolean[] visited = new boolean[numVertices];
        System.out.print("Depth First Traversal Recursive: ");
        dftHelper(vertex, visited);
    }

    /**
     * Performs a depth first search from the given vertex recursively
     * and prints out the order the nodes were visited.
     * 
     * @param vertex The vertex to perform the depth first search from.
     */
    private void dftHelper(int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr);
        for (int i = 0; i < adjacencyList.get(curr).size(); i++) {
            if (!visited[adjacencyList.get(curr).get(i)]) {
                dftHelper(adjacencyList.get(curr).get(i), visited);
            }
        }
    }

    /**
     * Prints out the path from the given starting vertex to the ending
     * vertex of a depth first search traversal.
     * 
     * @param start The starting vertex.
     * @param end The ending vertex.
     */
    public void depthFirstPath(int start, int end) {
        System.out.println("Depth First Path: ");
        int[] prev = depthFirstTraversalIterativePrint(start);
        System.out.print(end + " <-- ");
        int vertex = prev[end];
        while (vertex != -1) {
            System.out.print(vertex + " <-- ");
            vertex = prev[vertex];
        }
        System.out.println();
    }

    private boolean exists(ArrayList<Integer> list, int item) {
        boolean exists = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == item) {
                exists = true;
            }
        }
        return exists;
    }

    /**
     * Performs a breadth first search from the given vertex
     * and returns the previous vertices of each vertex visited as an array
     * in the order they were visited during the search. Prints out the
     * order the nodes were visited.
     * 
     * @param vertex The vertex to perform the depth first search from.
     * @return Previous vertices of each vertex an array in the order they were
     *         visited during the search.
     */    
    public int[] breadthFirstTraversalPrint(int vertex) {
        System.out.println();
        ArrayList<Integer> verticesVisited = new ArrayList<Integer>();
        int[] prev = null;
        if (vertex < numVertices && vertex >= 0) {
            System.out.print("Breadth First Traversal: ");
            Queue<Integer> queue = new LinkedList<Integer>();
            prev = new int[numVertices];
            for (int i = 0; i < prev.length; i++) {
                prev[i] = -1;
            }
            queue.add(vertex);
            System.out.print(vertex);
            verticesVisited.add(vertex);
            while (!queue.isEmpty()) {
                int dequeue = queue.remove();
                for (int i = 0; i < adjacencyList.get(dequeue).size(); i++) {
                    if (!exists(verticesVisited, adjacencyList.get(dequeue).get(i))) {
                        prev[adjacencyList.get(dequeue).get(i)] = dequeue;
                        queue.add(adjacencyList.get(dequeue).get(i));
                        verticesVisited.add(adjacencyList.get(dequeue).get(i));
                        System.out.print(adjacencyList.get(dequeue).get(i));
                    }
                }

            }
            System.out.println();
        }
        return prev;
    }

    public void breadthFirstPath(int start, int end) {
        System.out.println("Breadth First Path: ");
        int[] prev = breadthFirstTraversalPrint(start);
        System.out.print(end + " <-- ");
        int vertex = prev[end];
        while (vertex != -1) {
            System.out.print(vertex + " <-- ");
            vertex = prev[vertex];
        }
        System.out.println();
    }

    /**
     * Prints out this graph as an adjacency matrix and list.
     */
    public void print() {
        System.out.print("List:");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> " + adjacencyList.get(i).get(j));
            }
        }
        System.out.print("\n\nMatrix:\n");
        System.out.print("    ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("__");
        }
        System.out.println();
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
                if (adjacencyMatrix.get(i).get(j) == false) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}
