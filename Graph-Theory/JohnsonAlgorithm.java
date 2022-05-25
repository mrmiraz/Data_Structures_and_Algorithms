
package graph_theory;

/*
Impelmentation of Johnson Algorithms 

Step 1: Let the given graph be G. Add a new vertex p to the graph, add edges from new vertex to all vertices of weight 0 of G.
Let the modified graph be G’.
Step 2: Run Bellman-Ford algorithm on G’ with s as source. Let the distances calculated by Bellman-Ford be h[0], h[1], .. h[V-1]. 
        If we find a negative weight cycle, then return. Note that the negative weight cycle cannot be created by new vertex s as there is no edge to s.
        All edges are from s.
Step 3: Reweight the edges of original graph(weight will be positive).
        For each edge (u, v), assign the new weight as “original weight + h[u] – h[v]”.
Step 4: Remove the added vertex s and run Dijkstra’s algorithm for every vertex.
Step 5: Compute distance of original graph.
        dijkstraDistance[u][v] += bellmanfordDistance[v] - bellmanfordDistance[u]

Time Complexity: O(V^2log(V))

Sample Input:
3 5
0 1 8
1 0 12
0 2 22
2 0 6
1 2 4

Sample Output:
Distance matrix: 

	0	1	2	
0	0	8	12	
1	10	0	4	
2	6	14	0	
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JohnsonsAlgorithm {
    
    public static class Edge{
        int dest, weight;
        
        public Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
        public Edge(){};
    }
    
    ArrayList<ArrayList<Edge>> adjList;
    int nov;
    public JohnsonsAlgorithm(int nov) {
        this.nov = nov;
        adjList = new ArrayList<>();
        for(int i = 0; i < nov; i++){
            adjList.add(new ArrayList<>());
        }
    }
    
    public JohnsonsAlgorithm(int[][] matrix, int nov){
        this(nov);
        for(int i =0; i < nov; i++){
            for(int j = 0; j < nov; j++){
                if(matrix[i][j] != 0){
                    this.addEdge(i, j, matrix[i][j]);
                }
            }
        }
        
    }
    public void addEdge(int src, int dest, int weight){
       adjList.get(src).add(new Edge(dest, weight));
    }
    
    public int[] dijkstra(int src){
        boolean visited[] = new boolean[nov];
        int[] distance = new int[nov];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for(int i = 0; i < nov; i++){
            int minimumVertex = findMinimumVertex(distance, visited);
            visited[minimumVertex] = true;
            for(Edge neigbore: adjList.get(minimumVertex)){
                int u = minimumVertex;
                int v = neigbore.dest;
                int weight = neigbore.weight;
                if(!visited[v] && distance[u]+weight < distance[v]){
                    distance[v] = distance[u]+weight;
                }
            }
        }
        return distance;
    }
    
    public int findMinimumVertex(int[] distance, boolean[] visited){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < nov; i++){
            if(!visited[i] && distance[i] <= minValue){
                minValue = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    public int[] bellmanFord(int src, int nov){
        int[] distance = new int[nov];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for(int i = 0; i < nov-1; i++){
            //traverse every edges of the graph
            for(int j = 0; j < nov; j++){
                int curVertex = j;
                for(Edge edge: adjList.get(curVertex)){
                    int u = curVertex;
                    int v = edge.dest;
                    int weight = edge.weight;
                    if(distance[u] != Integer.MAX_VALUE && distance[u]+weight < distance[v]){
                        distance[v] = distance[u]+weight;
                    }
                }
            }
        }
        
        //checking negative cycle in the graph
        //traverse all the edge once again
        for(int j = 0; j < nov; j++){
            int curVertex = j;
            for(Edge edge: adjList.get(curVertex)){
                int u = curVertex;
                int v = edge.dest;
                int weight = edge.weight;
                if(distance[u] != Integer.MAX_VALUE && distance[u]+weight < distance[v]){
                        return null;
                }
            }
        }
        return distance;
    }
    
    public int[][] johnsons(int nov){
        //add a new vertex(p) to the original graph, each edge has 0 weight
        nov++;
        adjList.add(new ArrayList<>());
        for(int i = 0; i < nov-1; i++){
            addEdge(nov-1, i, 0);
        }
        
        int[] distance = bellmanFord(nov-1, nov);
        if(distance == null)return null;
        
        //changing weight to positive
        
        for(int i = 0; i < nov; i++){
            
            for(Edge edge: adjList.get(i)){
                int u = i; 
                int v = edge.dest;
                int weight = edge.weight;
                edge.weight = weight + distance[u]-distance[v];
            }
        }
        
        //remove extra node from the graph
        adjList.remove(nov-1);
        nov--;
        int[][] distances = new int[nov][];
        
        for(int i = 0; i < nov; i++){
            distances[i] = dijkstra(i);
        }
        
        //compute the distance in the original graph
        
        for(int i =0; i < nov; i++){
            for(int j = 0; j < nov; j++){
                if(distances[i][j] != Integer.MAX_VALUE){
                    distances[i][j] += (distance[j]-distance[i]);
                }
            }
        }
        return distances;
    }
    
    public static void main(String[] args) {
        
        /*
        int nov = 4;
        int[][] matrix = { { 0, 0, -2, 0 },
                                 { 4, 0, 3, 0 },
                                 { 0, 0, 0, 2 },
                                 { 0, -1, 0, 0 } };
        JohnsonsAlgorithm graph = new JohnsonsAlgorithm(matrix, nov);
        */
        
        Scanner sc = new Scanner(System.in);
        int nov = sc.nextInt();
        JohnsonsAlgorithm graph = new JohnsonsAlgorithm(nov);
        int edges = sc.nextInt();
        for(int i = 0; i < edges; i++){
            graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        
        int[][] distances = graph.johnsons(graph.nov);
        
        if(distances == null){
            System.out.println("Have negative weigth cycle");
            return;
        }
        
        System.out.println("Distance matrix: \n");
        System.out.print("\t");
        for(int i =0; i < nov; i++){
            System.out.print( i+"\t");
        }
        
        for(int i =0; i < nov; i++){
            System.out.println("");
            System.out.print( i+"\t");
            for(int j =0; j < nov; j++){
                if(distances[i][j] == Integer.MAX_VALUE)
                    System.out.print("X\t");
                else System.out.print(distances[i][j]+"\t");
            }
        }
        
    }
    
}
