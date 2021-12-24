package codefoces;
//  implementation of BFS
import java.util.*;

public class Graph {

    LinkedList<Integer> adj[];

    // constructor
    public Graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Adding edges
    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    // Finding the shortest path with BFS
    public int Bfs(int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[adj.length];
        boolean visited[] = new boolean[adj.length];
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        q.add(source);
        visited[source] = true;
        parent[source] = -1;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            if (curNode == destination) {
                break;
            }
            for (int i = 0; i < adj[curNode].size(); i++) {
                int neighbore = adj[curNode].get(i);
                if (visited[neighbore] != true) {
                    q.add(neighbore);
                    visited[neighbore] = true;
                    parent[neighbore] = curNode;
                }
            }
        }
        int distance = 0;
        int curNode = destination;
        while (parent[curNode] != -1) {
            System.out.println(curNode + "-->");
            curNode = parent[curNode];
            distance++;
        }
        return distance;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Vertices and Edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph graph = new Graph(v);
        System.out.println("Enter "+ e + " Edges: ");
        for(int i = 0; i < e; i++){
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
        System.out.println("Enter source node and destination node: ");
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println(graph.Bfs(source, destination));
    }
}

//https://www.youtube.com/watch?v=D21-XVw6nYw
