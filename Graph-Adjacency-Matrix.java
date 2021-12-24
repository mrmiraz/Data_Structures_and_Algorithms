public class MatrixGraph {

    int[][] adjMatrix;
    int numberOfNode;
    
    public MatrixGraph(int numberOfNode) {
        this.numberOfNode = numberOfNode;
        adjMatrix = new int[numberOfNode + 1][numberOfNode + 1];
    }
    
    //Weighted directed graph
    public void addEdge(int sourceNode, int destinationNode, int weight) {
        adjMatrix[sourceNode][destinationNode] = weight;
    }
    
    // Unweighted directed graph
    public void addEdge(int sourceNode, int destinationNode){
        adjMatrix[sourceNode][destinationNode] = 1;
    }
    
    // remove edge of directed graph
    public void removeEdge(int sourceNode, int destinationNode){
        adjMatrix[sourceNode][destinationNode] = 0;
    }
    
    // Undirected weighted graph
    public void addEdgeUndirected(int sourceNode, int destinationNode, int weight){
        adjMatrix[sourceNode][destinationNode] = adjMatrix[destinationNode][sourceNode] = weight;
    }
    
    //Undirected unweighted graph
    public void addEdgeUndirected(int sourceNode, int destinationNode){
        adjMatrix[sourceNode][destinationNode] = adjMatrix[destinationNode][sourceNode] = 1;
    }
    
    //remove edge of undirected graph
    public void removeEdgeUndirected(int sourceNode, int destinationNode){
        adjMatrix[sourceNode][destinationNode] = adjMatrix[sourceNode][destinationNode] = 0;
    }
    
    // print connected vertices
    public void connectedNodeOf(int node){
        for (int i = 1; i <= numberOfNode; i++) {
            if (adjMatrix[node][i] > 0) {
                System.out.println(node + "-->" + i + " : " + adjMatrix[node][i]);
            }
        }
    }
    
    // printing graph with matrix representation
    public void printMatrixRep() {
        for (int i = 1; i <= numberOfNode; i++) {
            for (int j = 1; j <= numberOfNode; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(4);
        graph.addEdge(1, 4, 5);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 1, 3);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 4, 4);
//        graph.add(4, 0, 0);
        graph.printMatrixRep();
//        graph.connectedNodeOf(4);
        graph.removeEdge(1, 4);
        graph.printMatrixRep();
    }
}
