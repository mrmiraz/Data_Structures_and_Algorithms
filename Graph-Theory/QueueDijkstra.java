import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class QueueDijkstra {
    
    class Node{
        int connectedNode;
        int weight;
        Node(int connectedNode, int weight){
            this.connectedNode = connectedNode;
            this.weight = weight;
        }
    }
    
    ArrayList<Node> graph[];
    int[] dist;
    boolean[] relax;
    int v;
    PriorityQueue<Node> pq;
     
    public void printMinDistance(int src){
        System.out.println("source: "+ src);
        for(int i = 0; i < v; i++){
            System.out.println("To : "+ i + " distance: "+ dist[i]);
        }
    }
    
    public void dijkstra(int source){
        dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        relax = new boolean[v];
        pq =new PriorityQueue<>((a,b)->Integer.compare(a.weight, b.weight));
        
        dist[source] = 0;
        pq.add(new Node(source, dist[source]));
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            relax[curNode.connectedNode] = true;
            for(Node child: graph[curNode.connectedNode]){
                if(!relax[child.connectedNode] && dist[curNode.connectedNode] + child.weight < dist[child.connectedNode]){
                   dist[child.connectedNode]= dist[curNode.connectedNode] + child.weight;
                   pq.add(new Node(child.connectedNode, dist[child.connectedNode]));
                }
            }
        }
        printMinDistance(source);
        
    }
    
    public static void main(String[] args) {
        QueueDijkstra d = new QueueDijkstra();
        Scanner sc = new Scanner(System.in);
        d.v = sc.nextInt();
        int edges = sc.nextInt();
        d.graph = new ArrayList[d.v];
        for(int i = 0; i < d.v; i++){
            d.graph[i] = new ArrayList<>();
        }
        for(int i = 0;i < edges; i++){
            int source = sc.nextInt(),dest = sc.nextInt(), weight = sc.nextInt();
            d.graph[source].add(d.new Node(dest, weight));
        }
        d.dijkstra(0);
        
    }
    
}
