import java.util.*;
public class MaximumMatchingBipartite {
    
    static ArrayList<Integer> graph[];
    static boolean used[];
    static int matchingArray[];
    static int boys, girls, relations, edges, vertices;
    
    static boolean kuhn(int v){
        if(used[v])return false;
        used[v] = true;
        for(int cNode: graph[v]){
            if(matchingArray[cNode] == -1 || kuhn(matchingArray[cNode])){
                matchingArray[cNode] = v;
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertices = sc.nextInt(); edges = sc.nextInt();
        used = new boolean[vertices]; matchingArray = new int[vertices];
        Arrays.fill(matchingArray, -1);
        graph = new ArrayList[vertices];
        
        for(int i = 0; i < vertices; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges; i++){
            int source = sc.nextInt(), destination = sc.nextInt();
            graph[source].add(destination);
        }
        
        int cnt = 0;
        for(int i = 0; i < vertices; i++){
            Arrays.fill(used, false);
            if(kuhn(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
