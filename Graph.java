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
}
