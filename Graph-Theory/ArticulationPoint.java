/*
Finding articulation point of a graph.
Step 1: Find each of the vertex discovery time using dfs
Step 2: Set lowest discovery time using min(lowestTime[curVertex], lowestTime[child]
        if child has already visited then disc[curVertex] = min(lowestTime[child], discTime[curVertex])
Step 3: If lowestTime[child] <= discTime[curVertex] then curVertex is an ap
Step 4: If root has more than one children then root is is


Time Complexity: O(V+E) 

Sample input: 
7 8
0 1
1 2
2 0
1 3
1 4
1 6
3 5
4 5

Sample output:
Articulation point of a graph is:1
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ArticulationPoint {
    
    ArrayList<ArrayList<Integer>> adjList;
    int V;

    public ArticulationPoint(int v) {
        this.V = v;
        adjList = new ArrayList<>();
        for(int i =0; i < v; i++){
            adjList.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
    
    public void apfind(){
        boolean visited[] = new boolean[V];
        int[] discTime = new int[V];
        int[] lowestTime = new int[V];
        boolean[] isAp = new boolean[V];
        
        int time = 0, parent = -1;
        for(int i = 0;i < V; i++){
            if(!visited[i]){
                dfs(visited, discTime,lowestTime, isAp, i, parent, time);
            }
        }
        System.out.print("Articulation point of the graph is:");
        for(int i =0; i < V; i++){
            if(isAp[i]){
                System.out.print(i + " ");
            }
        }
        
    }
    
    public void dfs(boolean[] visited, int[] discTime,int[] lowestTime, boolean[] isAp, int curVertex,int parent,int time){
        visited[curVertex] = true;
        discTime[curVertex] =lowestTime[curVertex]= ++time;
        int children = 0;
        for(int child: adjList.get(curVertex)){
            
            if(!visited[child]){
                children++;
                dfs(visited, discTime, lowestTime, isAp, child, curVertex, time);
                
                lowestTime[curVertex] = Math.min(lowestTime[curVertex], lowestTime[child]);
                if(parent != -1 && lowestTime[child] >= discTime[curVertex]){
                    isAp[curVertex] = true;
                }
            }
            // If child is already visited and is not curVertex's parent
            else if(child != parent){
                lowestTime[curVertex] = Math.min(lowestTime[child], discTime[curVertex]);
            }
        }
        
        //If root has more than one children
        if(parent == -1 && children > 1){
            isAp[curVertex] = true;
        }
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int edges = sc.nextInt();
        ArticulationPoint graph = new ArticulationPoint(v);
        for(int i = 0;i < edges; i++){
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        
        graph.addEdge( 0, 1);
        graph.addEdge( 1, 2);
        graph.addEdge( 2, 0);
        graph.addEdge( 1, 3);
        graph.addEdge( 1, 4);
        graph.addEdge( 1, 6);
        graph.addEdge( 3, 5);
        graph.addEdge( 4, 5);
        graph.apfind();
        
    }
}
