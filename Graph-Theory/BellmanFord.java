
package graph_theory;

/*
Implementation of Bellman Ford Algorithms finding single source shortest path
of with negative weight

Step 1: Set all vertext distance to infinite(source is 0)
Step 2: Change vextex distance number of vertex-1 times for every edges each time
Step 3: If dist[u]+weight < dist[v] then change the dist[v] to dist[u]+weight
Step 4: Run another loop for checking negative cycle
        if(dist[u]+weight < dist[v]) then there is a negative cycle

Time Complexity: O(VE)

Sample Input:
5 8
0 1 -1
0 2 4
1 2 3
1 3 2
3 1 1
3 2 5
1 4 2
4 3 -3

Sample Output:
Distance from 0
to 0 is 0
to 1 is -1
to 2 is 2
to 3 is -2
to 4 is 1

*/
import java.util.*;


public class BellmanFord {
    
    static class Edges{
        int src, dest, weight;
        Edges(){
        src = dest = weight = 0;
        };
    }
    
    
    static void bellmanFord(Edges edges[],int nov, int noe, int src){
        int INF = 9999;
        int[] dist = new int[nov];
        Arrays.fill(dist, 9999);
        dist[src] = 0;
        // Run a vertex-1 times loop for distance change
        for(int i = 0;i < nov-1; i++){
            //distance changing for all edges 
            for(int j = 0; j < noe; j++){
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                dist[v] = Math.min(dist[u]+weight, dist[v]);
            }
        }
        
        //checking negative cycle
        for(int i =0; i < noe; i++){
            int u = edges[i].src;
            int v = edges[i].dest;
            int weight = edges[i].weight;
            if(dist[u]+weight < dist[v]){
                return;
            }
        }
        System.out.println("Distance from "+ src);
        for(int i =0; i < nov; i++){
            System.out.println("to "+ i + " is " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
//        BellmanFord graph = new BellmanFord();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e  = sc.nextInt();
        Edges[] edges = new Edges[e];
        for(int i =0;i < e; i++){
            edges[i] = new Edges();
        }
        
        for(int i = 0;i < e; i++){
            int src = sc.nextInt(), dest = sc.nextInt(), weight = sc.nextInt();
            edges[i].src = src;
            edges[i].dest = dest;
            edges[i].weight = weight;
        }
        
        bellmanFord(edges,v, e, 0);
    }
}
