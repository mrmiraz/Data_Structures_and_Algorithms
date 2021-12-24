import java.util.LinkedList;

public class GraphList {
    
    public class Edge{
        int sourceNode;
        int destinationNode;
        int weight;

        public Edge(int sourceNode, int destinationNode, int weight) {
            this.sourceNode = sourceNode;
            this.destinationNode = destinationNode;
            this.weight = weight;
        }
        
        public Edge(int sourceNode, int destinationNode){
            this.sourceNode = sourceNode;
            this.destinationNode = destinationNode;
            this.weight = 1;
        }
    }
    
    LinkedList<Edge>[] adjList;
    int numOfVertices;

    public GraphList(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjList = new LinkedList[numOfVertices+1];
        
        for(int i = 1; i <= numOfVertices; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    
    //add edge in directed Unweighted graph
    public void addEdge(int sourceNode, int destinationNode){
        adjList[sourceNode].add(new Edge(sourceNode, destinationNode));
    }
    
    // add edge in directed weighted graph
    public void addEdge(int sourceNode, int destinationNode, int weight){
        adjList[sourceNode].add(new Edge(sourceNode, destinationNode, weight));
    }
    
    //remove edge from the directed graph
    public void removeEdge(int sourceNode, int destinationNode){
        
        for(Edge i : adjList[sourceNode]){
            if(i.destinationNode == destinationNode){
                adjList[sourceNode].remove(i);
                 break;
            }
        }
    }
    
    //add edge in undirected unweighted graph
    public void addEdgeUndirected(int sourceNode, int destinationNode){
        adjList[sourceNode].add(new Edge(sourceNode, destinationNode));
        adjList[destinationNode].add(new Edge(destinationNode, sourceNode));
    }
    
    //add edge in undirected weighted graph
    public void addEdgeUndirected(int sourceNode, int destinationNode, int weight){
        adjList[sourceNode].add(new Edge(sourceNode, destinationNode, weight));
        adjList[destinationNode].add(new Edge(destinationNode, sourceNode, weight));
    }
    
    //remove edge from the undirected graph
    public void removeEdgeUndirected(int sourceNode, int destinationNode){
        removeEdge(sourceNode, destinationNode);
        removeEdge(destinationNode, sourceNode);
    }
    
    //print all the vertices, are connected with desire vertice
    public void getConnectedNode(int node){
        System.out.print(node);
        for(Edge i : adjList[node]){
            System.out.print("-->"+ i.destinationNode + "("+i.weight + ")");
        }
        System.out.println();
    }
    
    //print the graph as list
    public void printGraphList(){
        for(int i = 1; i <= numOfVertices; i++){
            System.out.print(i);
            for(Edge  j : adjList[i]){
                System.out.print("-->" + j.destinationNode + "("+ j.weight + ")");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        GraphList graph = new GraphList(4);
        graph.addEdge(1, 4, 5);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 1, 3);
        graph.addEdge(3, 2, 2);
//        graph.removeEdgeUndirected(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 3);
//        graph.addEdge(1, 2);
//        graph.connectedNodeOf(1);
        graph.printGraphList();
        
        System.out.println("new line");
        graph.removeEdge(1, 2);
        graph.printGraphList();
    }
}
