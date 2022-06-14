/*
Problem:Given a distance ‘dist’, count total number of ways to cover the distance with 1, 2 and 3 steps. 

Algorithm: 
Step 1: Create an array of size n + 1 and initialize the first 3 variables with 1, 1, 2. The base cases.
Step 2: Run a loop from 3 to n.
Step 3: For each index i, compute value of ith position as dp[i] = dp[i-1] + dp[i-2] + dp[i-3].
Step 4: Print the value of dp[n], as the Count of number of ways to cover a distance.

Time Complexity: O(N)

Sample input:
4
Sample output:
7
*/
public class CoverDistance {
    
    //recursion solution
    //O(3^n): O(1)
    public static int printCountRec(int dist){
        if(dist == 0)return 1;
        if(dist < 0) return 0;
        
        return printCountRec(dist-1)+
                printCountRec(dist-2)+
                printCountRec(dist-3);
    }
    
    //top down approch //O(N):O(N)
    public static int printCountdp(int dist){
        int[] dp = new int[dist+1];
        dp[0] = 1;
        if(dist >= 1)dp[1] = 1;
        if(dist >= 2) dp[2] = 2;
        for(int i = 3; i <= dist; i++){
            dp[i] = dp[i-1] + dp[i-2]+ dp[i-3];
        }
        return dp[dist];
    }
    
    public static void main(String[] args) {
        int dist = 4;
        System.out.println(printCountdp(dist));
    }
}
