package learning.Solution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    LinkedList<Integer> adj[];

    public Graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceNode, int destinationNode) {
        adj[sourceNode].add(destinationNode);
//        adj[destinationNode].add(sourceNode);
    }

    public void printGraph() {
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i);
            for (int element : adj[i]) {
                System.out.print("-->" + element);
            }
            System.out.println("\n");
        }
    }

    public void bfs(int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.length];
        q.add(sourceNode);
        visited[sourceNode] = true;

        while (!q.isEmpty()) {
            int pollNode = q.poll();
            System.out.print(pollNode + " ");
            Iterator<Integer> i = adj[pollNode].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
//            for(int element: adj[pollNode]){
//            if(!visited[element]){
//                q.add(element);
//                visited[element] = true;
//            }
//        }
        }
    }

    public void dfsUtil(int sourceNode, boolean[] visited) {
        visited[sourceNode] = true;
        System.out.println(sourceNode + " ");
        for (int element : adj[sourceNode]) {
            if (!visited[element]) {
                dfsUtil(element, visited);
            }
        }

    }

    public void dfs(int sourceNode) {
        boolean[] visited = new boolean[adj.length];
        dfsUtil(sourceNode, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(2, 3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 2);
        g.dfs(0);

//        g.bfs(0);
    }

}
