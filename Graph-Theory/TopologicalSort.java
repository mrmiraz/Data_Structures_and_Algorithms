/*
Implementation of Topologica sort using dfs
Step 1: Run dfs over all the vertices 
Step 2: Push all vertex to a stack when returning the recursion in dfs
Step 3: Pop all the element from the stack
Time Complexity: O(V+E). 


Sample Input:
6 8
0 3
0 2
2 3
3 1
2 1
5 1
5 4
1 4

Sample output:
5 0 2 3 1 4
*/


import java.util.*;

public class TopologicalSort {
    static ArrayList<Integer> graph[];
    static boolean[] visited;
    static int v;
    static Stack<Integer> stack;
    
    static void dfs(int v){
        visited[v] = true;
        for(int child: graph[v]){
            if(!visited[child]){
                dfs(child);
            }
        }
        stack.push(v);
    }
    
    static void topoSort(){
        
        visited = new boolean[v];
        stack = new Stack<>();
        for(int i =0; i < v; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        int edges = sc.nextInt();
        graph = new ArrayList[v];
        for(int i =0; i < v; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i =0; i < edges; i++){
            int src = sc.nextInt(), dest = sc.nextInt();
            graph[src].add(dest);
        }
        topoSort();
    }
}
