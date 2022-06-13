/*
0/1 Knapsack problem
Problem: You are given weights and values of N items, put these items in a knapsack of 
capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.

Algorithm:
Step 1: Take dp of size of [N+1][W+1]
Step 2: If weigh is greater than the total current weight then dp[i][j] = dp[i-1][j]
        (weight is not takable)
Step 3: If I not take what will be my profit
        If I take weight what will be profit and what will be remaining current weight profit
        Take the maximum of those
        dp[i][j] = max(dp[i-1][j], p[i-1]+dp[i-1][j-wt[i-1]])
Step 4: return last value of dp (dp[n][W])

Time Complexity: O(N*W) // W = total Weight

Sample input:
wt = [10, 20, 30]
profit = [60, 100, 120]
W = 50
Sample output:
220

*/
public class Knapsack {
    public static int knapsack(int[] wt, int[] p, int W){
        int size = wt.length;
        int[][] dp = new int[size+1][W+1];
        
        for(int i = 0; i <= size; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0)dp[i][j] = 0;
                else if(wt[i-1] > j) dp[i][j] = dp[i-1][j]; //if weight is not takable 
                else{
                    // take maximum profit of take or not take the weight
                    dp[i][j] = Math.max(dp[i-1][j], p[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }
        
        return dp[size][W];
    }
    
    public static void main(String[] args) {
        
        int[] wt = {10, 20, 30};
        int[] p = {60, 100, 120};
        System.out.println(knapsack(wt, p, 50));
    }
}
