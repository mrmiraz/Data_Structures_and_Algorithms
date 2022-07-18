/*
Problem:
We are given an array and a set of query ranges, we are required to find the sum of every query range.

Time Complexity: O(n*root(n)long(n))
Sample input:
arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};
query[] = [0, 4], [1, 3] [2, 4]

Sample output:
Sum in range [1,3]: 4
Sum in range [0,4]: 8
Sum in range [2,4]: 6
*/
import java.util.*;
public class MOsAlgorithm {
    public static class Query{
        int l, r;
        Query(int l, int r){
            this.l = l;
            this.r = r;
        }
    }
    
    public static void mosAlgorithm(int input[], ArrayList<Query> q, int m){
        int blockN = (int)Math.sqrt(input.length)+1;
        Collections.sort(q, (o1, o2) -> {
            //if query are in different block sort ascending following l
            if(o1.l/blockN != o2.l/blockN){
                return (o1.l < o2.l)? -1:1;
            }
            //if query are in same block then sort ascending following r
            return (o1.r < o2.r)? -1:1;
        });
        
        int curSum = 0, curL = 0, curR = 0;
        for(int i = 0; i < m; i++){
            int l = q.get(i).l, r = q.get(i).r;
            
            //if curL is in left of the query l
            while(curL < l){
                curSum -= input[curL];
                curL++;
            }
            
            //if curL is in right position than the l
            while(curL > l){
                curSum += input[curL];
                curL--;
            }
            //if curR is in the left possition than the r
            while(curR <= r){
                curSum += input[curR];
                curR++;
            }
            
            //if curR is in the right possition than the r
            while(curR > r+1){
                curSum -= input[curR];
                curR--;
            }
            System.out.println("Sum in range [" + l + ","+ r + "]: " + curSum);
        }
    }
    
    public static void main(String args[]){
        ArrayList<Query> q = new ArrayList<>();
        int m = 3; // number of query
        q.add(new Query(0,4));
        q.add(new Query(1,3));
        q.add(new Query(2,4));
        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        mosAlgorithm(a, q, m);
        
    }
}
