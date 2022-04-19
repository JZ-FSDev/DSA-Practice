import java.util.ArrayList;

public class Graph {

    private ArrayList<ArrayList<Integer>> adjacencyList;
    private ArrayList<ArrayList<Boolean>> adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices){
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<ArrayList<Integer>>();
        adjacencyMatrix = new ArrayList<ArrayList<Boolean>>();

        for(int i = 0; i < numVertices; i++){
            adjacencyList.add(new ArrayList<Integer>());
            adjacencyMatrix.add(new ArrayList<Boolean>());
            for(int j = 0; j < numVertices; j++){
                adjacencyMatrix.get(i).add(false);
            }
        }
    }
    

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);

        graph.print();
    }
    
    public void addEdge(int from, int to) {
        orderedInsert(adjacencyList.get(from), to);
        orderedInsert(adjacencyList.get(to), from);

        adjacencyMatrix.get(from).set(to, true);
        adjacencyMatrix.get(to).set(from, true);
    }

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
    
    public int[] depthFirstTraversalPrint(int vertex) {
        System.out.println();
        ArrayList<Integer> verticesVisited = new ArrayList<Integer>();
        int[] prev = null;
        if (vertex < numVertices && vertex >= 0) {
            System.out.print("Depth First Traversal: ");
            Stack<Integer> stack = new Stack<Integer>();
            prev = new int[numVertices];
            stack.push(vertex);
            verticesVisited.add(vertex);
            System.out.print(vertex);    
    
    public void print() {
        System.out.println("List:");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> " + adjacencyList.get(i).get(j));
            }
        }
        System.out.print("\n\nMatrix:\n");
        System.out.print("    ");
        for(int i = 0; i < numVertices; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("   ");
        for(int i = 0; i < numVertices; i++){
            System.out.print("__");
        }
        System.out.println();
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
                if(adjacencyMatrix.get(i).get(j) == false){
                    System.out.print("0 ");
                }else{
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }    
}
