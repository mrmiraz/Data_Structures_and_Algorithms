/*
Implementation of Floyd Warshall Algorithms
Step 1:  k is not an intermediate vertex in shortest path from i to j. We keep the value of graph[i][j] as it is. 
Step 2: k is an intermediate vertex in shortest path from i to j. We update the value of 
        graph[i][j] as graph[i][k] + graph[k][j] if graph[i][j] > graph[i][k] + graph[k][j]
Time Complexity: O(V^3)
*/



public class FloydWarshall {
    
    static int INF = 9999;
    static void floydWarshall(int[][] graph){
        
        int V = graph.length;
        for(int i =0; i <V; i++){
            for(int j =0; j < V; j++){
                if(i == j)continue;
                if(graph[i][j] == 0)graph[i][j] = INF;
            }
        }
        
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
    }
    
    static void printSolution(int dist[][])
    {
        int V = dist.length;
        System.out.println("The following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
  
    public static void main(String[] args) {
        int graph[][] = { {0,   5,  0, 10},
                          {0, 0,   3, 0},
                          {0, 0, 0,   1},
                          {0, 0, 0, 0}
                        };
        floydWarshall(graph);
        printSolution(graph);
        
    }
}
