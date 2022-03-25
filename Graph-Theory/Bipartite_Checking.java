import java.util.*;
public class CheckBipartite {
    
     static boolean isBipartiteUtil(int graph[][], int source, int color[]){
         Queue<Integer> q  = new LinkedList<>();
         int V = graph[0].length;
         q.add(source);
         color[source] = 1;
         while(!q.isEmpty()){
             int cur_node = q.poll();
             if(graph[cur_node][cur_node] == 1)return false;
             for(int nb = 0; nb < V; ++nb){
                 if(graph[cur_node][nb] == 1 && color[nb] == -1){
                     q.add(nb);
                     // assing oposite color to the neghbore node
                     color[nb] = 1 - color[cur_node];
                 }
                 else if(graph[cur_node][nb] == 1 && color[cur_node] == color[nb]){
                     //if two adjacent vertices has same color
                     return false;
                 }
             }
         }
         return true;
     }
    
     static boolean isBipartite(int graph[][], int source){
         int V = graph[0].length;
         int color[] = new int[V];
         Arrays.fill(color, -1);
         for(int i =0; i < V; i++){
             if(color[i] == -1){
                 if(!isBipartiteUtil(graph, i , color)){
                     return false;
                 }
             }
         }
         return true;
     }
     
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int graph[][] = new int[V][V];
        for(int i = 0; i < V; i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph[source][destination] = 1;
            graph[destination][source] = 1;
        }
         System.out.print(isBipartite(graph, 0));
    }
     
}
