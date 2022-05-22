
/*
Implementation of Breath First Search
Step 1: Star from source node, add it to queue and set it visited
Step 2: Poll vertex from queue and add all neighbore into the queue which are not visited 
Step 3: Repeat step 2 until the queue is empty

Time complixity: O(V+E)
Auxiliary Space: O(V)
*/

import java.util.*;

public class BFS {
    static boolean visited[];
    static ArrayList<Integer> graph[];
    static int V;
    static Queue<Integer> q;
    
    static void recursion(){
        if(q.isEmpty())return;
        int node = q.poll();
        System.out.print(node + " ");
        for(int cNode: graph[node]){
            if(!visited[cNode]){
                q.add(cNode);
                visited[cNode] = true; 
            }
        }
        recursion();
    }
    
    static void recursiveBfs(int v){
        q.add(v);
        visited[v] = true;
        recursion();
    }
    
    static void bfs( int source){
        // add the source node and mark as visited node
        q.add(source);
        visited[source] = true;
        // iterate until the queue is empty
        while(!q.isEmpty()){
            int curNode = q.poll();
            System.out.print(curNode + " ");
            //Go through all neighbore of poll vertex of the queue
            for(int neighbore : graph[curNode]){
                //if neighbore is not visite add it to the queue and mark as visited
                if(!visited[neighbore]){
                    visited[neighbore] = true;
                    q.add(neighbore);
                    
                }
            }
        }
    }
    
    public static void main(String[] args) {
       V= 4;
        graph = new ArrayList[V];
        for(int i =0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        visited =  new boolean[V];
        q = new LinkedList<>();
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(2);
        graph[2].add(0);
        graph[2].add(3);
        graph[3].add(3);
        recursiveBfs(2);
//        bfs(2);
        
    }
}

