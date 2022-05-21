/*
Implementation of Kruskal Algorithms
Step 1: Sort the edges in ascending order with value of weights 
Step 2: Peek a edges and check wheather it is form a cycle or not
Step 3: If do not form a cycle then add the edges in mst
Step 4: perform Step 2 and 3 until you have number of edges of (vertices-1)

input :

9 14
0 1 4
0 7 8
1 7 11
1 2 8
7 6 1
7 8 7
2 8 2
6 8 6
6 5 2
2 5 4
2 3 7
3 5 14
3 4 9
5 4 10
*/


import java.util.Arrays;
import java.util.Scanner;
public class KruskalAlgorithm {
    
    int v, e;
    Edges[] edges;
    class Edges{
        int src, des, weight;
    }
    public KruskalAlgorithm(int v, int e) {
        this.v = v;
        this.e = e;
        edges = new Edges[e];
        for(int i =0; i < e; i++){
            edges[i] = new Edges();
        }
    }
    
    public static void union(int[] parent, int x, int y){
        parent[x] = y;
    }
    
    public static int find(int[] parent, int x){
        if(parent[x] == -1)return x;
        return find(parent, parent[x]);
    }
    
    public static void printMst(KruskalAlgorithm graph){
        int weight = 0;
        for(int i =0; i < graph.e; i++){
            System.out.println(graph.edges[i].src + " "+graph.edges[i].des + " "+graph.edges[i].weight);
            weight += graph.edges[i].weight;
        }
        System.out.println("total: " + weight);
    }
    
    public static void mst(KruskalAlgorithm graph){
        int[] parent = new int[graph.v];
        Arrays.fill(parent, -1);
        Arrays.sort(graph.edges, (a, b)-> Integer.compare(a.weight, b.weight));
        KruskalAlgorithm graph1 = new KruskalAlgorithm(graph.v, graph.v-1);
        int j = 0, i  = 0;
        while(j < graph.v -1){
            int x = find(parent, graph.edges[i].src);
            int y = find(parent, graph.edges[i].des);
            if(x != y){
                union(parent, graph.edges[i].src, graph.edges[i].des);
                graph1.edges[j].src = graph.edges[i].src;
                graph1.edges[j].des = graph.edges[i].des;
                graph1.edges[j++].weight = graph.edges[i].weight;
            }
            i++;
        }
        
        printMst(graph1);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(), e = sc.nextInt();
        KruskalAlgorithm graph = new KruskalAlgorithm(v, e);
        for(int i = 0; i < e; i++){
            graph.edges[i].src = sc.nextInt();
            graph.edges[i].des = sc.nextInt();
            graph.edges[i].weight = sc.nextInt();
        }
        
        mst(graph);
    }
}
