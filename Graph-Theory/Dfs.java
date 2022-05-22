/*
Implementation of Dfs 
Create a recursive function that takes the index of the node and a visited array.
Step 1: Mark the current node as visited and print the node.
Step 2: Traverse all the adjacent and unmarked nodes and 
        call the recursive function with the index of the adjacent node.

Time complexity: O(V+E)
Space Complexity: O(V)
*/
import java.util.ArrayList;


public class Dfs {
    static ArrayList<Integer> graph[];
    static boolean[] visited;
    
    static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        for(int cNode: graph[v]){
            if(!visited[cNode]){
                dfs(cNode);
            }
        }
    }
    
    
    public static void main(String[] args){
        int v = 4;
        graph = new ArrayList[v];
        for(int i =0; i < v; i++){
            graph[i] = new ArrayList<>();
        }
        visited =  new boolean[v];
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(2);
        graph[2].add(0);
        graph[2].add(3);
        graph[3].add(3);
        System.out.println("Depth First Search Traversal: ");
        dfs(2);
        
    }
}
