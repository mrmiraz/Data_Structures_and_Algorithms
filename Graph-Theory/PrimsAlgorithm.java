import java.util.*;
public class PrimsAlgorithm {
    
    int v;
    public int getMinKey(HashSet<Integer> mstSet, int[] keySet ){
        int minIndex = 0;
        for(int i = 0; i < v;i++){
            if(!mstSet.contains(i) && keySet[minIndex] > keySet[i]){
               minIndex = i; 
               
            }
        }
        return minIndex;
    }
    
    
    public void primMst(int[][] graph, int[] parent){
        // mstSet will add which is already chosen
        HashSet<Integer> mstSet = new HashSet<>();
        
        int[] keySet = new int[v];
        parent[0] = -1;
        keySet[0] = 0;
        Arrays.fill(keySet, Integer.MAX_VALUE);
        for(int i =0; i < v-1; i++){
            int minKey = getMinKey(mstSet, keySet);
            mstSet.add(minKey);
            for(int j = 0; j < v; j++){
                //node should be connected
                //node should not be in mst set
                //value of keySet Value of current node should be minimum than the weight of current node
                if(graph[i][j] != 0 && keySet[j] > graph[i][j] && !mstSet.contains(j)){
                    parent[j] = i;
                    keySet[j] = graph[i][j];
                }
            }
        }
        
    }
    
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < v; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
    
    public static void main(String[] args){
        
        PrimsAlgorithm t = new PrimsAlgorithm();
        t.v = 6;
        int graph[][] = { { 0, 7, 8, 0, 0 , 0},
                        { 7, 0, 3, 6, 0, 0 },
                        { 8, 3, 0, 4, 3 , 0},
                        { 0, 6, 4, 0, 2 , 5},
                        { 0, 0, 3, 2, 0 , 2},
                        {0, 0, 0, 5, 2, 0}};
 
        int[] parent = new int[t.v];
        t.primMst(graph, parent);
        
        t.printMST(parent, graph);
    }
}
