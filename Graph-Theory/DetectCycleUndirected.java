/*
Finding cycle in undirected graph
Step 1: Run a dfs over the graph
Step 2: Check if there is child vertex which is already visited
        and is not parent of current vertex
Step 3: Return true if any vertex return a true
Time Complexity: O(V+E)

Sample input:
5 5 
1 0
0 2
2 1
0 3
3 4
Sample output:
true
*/
import java.util.ArrayList;
import java.util.Scanner;


public class CycleDetect {
    ArrayList<ArrayList<Integer>> adjList;
    int V;
    public CycleDetect(int v){
        this.V = v;
        
        adjList = new ArrayList<>();
        for(int i = 0;i < V; i++){
            adjList.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int src, int desc){
        adjList.get(src).add(desc);
        adjList.get(desc).add(src);
    }
    
    public boolean dfs(boolean visited[], int curVertex, int parent){
        visited[curVertex] = true;
        for(int child: adjList.get(curVertex)){
            if(!visited[child]){
                if(dfs(visited, child, curVertex))
                    return true;
            }
            // Child is already visited and child is not parent of current vertex
            else if(child != parent){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCyclic(){
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(visited, i, -1))
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int edges = sc.nextInt();
        
        CycleDetect graph = new CycleDetect(v);
        for(int i =0;i < edges; i++){
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        System.out.println(graph.isCyclic());
        
    }
}
