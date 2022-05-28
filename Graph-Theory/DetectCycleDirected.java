/*
Finding cycle in directed graph

Step 1: Run a dfs over the graph
Step 2: Detect all vertex which are visited in the current dfs session(use boolean array)
Step 3: If neighbore of current vertex's is visited and is visited in the current session then there is cycle
Step 4: Traversed all the unvisited vertex like above
Time complexity: O(V+E)

Sample input:
4 6
0 1
0 2
1 2
2 0
2 3
3 3
Sample output:
true
*/

import java.util.ArrayList;
import java.util.Scanner;
public class DetectCycleDirected {
     ArrayList<ArrayList<Integer>> adjList;
    int V;
    public DetectCycleDirected(int v){
        this.V = v;
        adjList = new ArrayList<>();
        for(int i = 0;i < V; i++){
            adjList.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int src, int desc){
        adjList.get(src).add(desc);
    }
    
    public boolean dfs(boolean[] visited,boolean[] inRecStack, int curVertex){
        visited[curVertex] = true;
        inRecStack[curVertex] = true;
        for(int child: adjList.get(curVertex)){
            if(!visited[child]){
               if(dfs(visited, inRecStack, child))return true;
            }
            else if(inRecStack[child])return true;
        }
        inRecStack[curVertex] = false;
        return false;
    }
    
    public boolean isCyclic(){
        boolean[] visited = new boolean[V];
        boolean[] inRecStack = new boolean[V];
        for(int i =0; i < V; i++){
            if(!visited[i]){
                if(dfs(visited,inRecStack, i))return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v= sc.nextInt();
        int edges = sc.nextInt();
        DetectCycleDirected graph = new DetectCycleDirected(v);
        for(int i =0; i < edges; i++){
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        System.out.println(graph.isCyclic());
         
    }
}
