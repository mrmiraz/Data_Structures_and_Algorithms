/*
Implementation of Dijkstra algorithm finding shortest path
Step 1: Set each vertex value with infinite(source set zero) which represents distance from source vertex
        Take relax array which represents vertex is relaxed
Step 2: Find minimum distance vertex(parent) and take this in relax set
Step 3: Travel each neighbore of parent vertex which is not relax and 
        set the distance of neighbore which greater distance than the summation of 
        weight and distance of parent
Step 4: Repeat step 2 and 3 untill it relax all the vertex

Time Complexity: O(V^2)

*/

import java.util.Arrays;

public class Disjktra {
    
    static int v;
    
    public static void printMinDistance(int[][] graph,int[] dist, int src){
        System.out.println("source: "+ src);
        for(int i = 0; i < v; i++){
            System.out.println("To : "+ i + " distance: "+ dist[i]);
        }
    }
    
    public static int findMinVertex(int[] dist, boolean[] relaxSet){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i =0; i < v; i++){
            if(min > dist[i] && !relaxSet[i]){
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    
    public static void dijkstra(int[][] graph, int src){
        int[] dist = new int[v];
        int[] parent = new int[v];
        boolean[] relaxSet = new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        parent[src] = -1;
        dist[src] = 0;
        
        for(int i = 0; i < v-1; i++){
            int parentVertex = findMinVertex(dist, relaxSet);
            relaxSet[parentVertex] = true;
            for(int child = 0; child < v; child++){
                if(graph[parentVertex][child] != 0 && !relaxSet[child] && (dist[parentVertex]+graph[parentVertex][child])<dist[child]){
                    parent[child]  = parentVertex;
                    dist[child] = dist[parentVertex]+graph[parentVertex][child];
                }
            }
        }
        
        printMinDistance(graph,dist, src);
        
    }
    public static void main(String[] args) {
        v = 9;
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra(graph, 0);
        
    }
}
