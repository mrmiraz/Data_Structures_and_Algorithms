import java.util.Arrays;
import java.util.Scanner;

public class UnionFindDisjoint {
    
    int v, e;
    
    class Edges{
        int src, des;
    }
    
    Edges[] edges ;
    public UnionFindDisjoint(int v, int e) {
        this.v  = v;
        this.e = e;
        edges = new Edges[e];
        for(int i = 0; i < e; i++){
            edges[i] = new Edges();
        }
    }
    
    public static void union(int[] parent, int x, int y){
        parent[x] = y;
    }
    
    public static int find(int[] parent, int i){
        if(parent[i] == -1)return i;
        return find(parent, parent[i]);
    }
    
    
    public static boolean isCycle(UnionFindDisjoint graph){
        int[] parent = new int[graph.v];
        Arrays.fill(parent, -1);
        for(int i = 0;i < graph.e; i++){
            int x = find(parent, graph.edges[i].src);
            int y = find(parent, graph.edges[i].des);
            if(x == y)return true;
            union(parent, x, y);
        }

        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(), e = sc.nextInt();
        UnionFindDisjoint graph = new UnionFindDisjoint(v, e);
        
        for(int i =0; i < e; i++){
            graph.edges[i].src = sc.nextInt();
            graph.edges[i].des = sc.nextInt();
        }
        
       System.out.println(isCycle(graph));
    }
}
