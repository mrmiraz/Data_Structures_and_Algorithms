/*
Problem:
Consider a row of n coins of values v1 . . . vn, where n is even. 
We play a game against an opponent by alternating turns. 
In each turn, a player selects either the first or last coin from the row, 
removes it from the row permanently, and receives the value of the coin. 
Determine the maximum possible amount of money we can definitely win if we move first.
Note: The opponent is as clever as the user.

Algorithm:
Step 1: If i choose first value, oponent will choose second or last value:
            If oponent chose second value then he left for me third and last value
            If oponent choose last value then he left for me second and second last value
        x = a[i] + min((i+2, j), (i+1, j-1))
Step 2: If i choose last value, oponent will choose first or second last value:
            If oponent choose first value then he left for me second and second last value
            If oponent choose second last value then he left for me first and third last value
        y = a[j] + min((i+1, j-1), (i, j-1))

Step 3: pick maximum(x, y)

Time Complexity: O(n^2)
Sample input:
arr =[ 8, 15, 3, 7 ]
Sample output:
22

*/

public class OptimalStrategyGame {
    
    public static int solve(int[] a,int[][] dp, int i, int j){
        if(i > j)return 0;
        
        // when already subproblems are solved 
        if(dp[i][j] != -1)return dp[i][j];
        int x = a[i] + Math.min(solve(a, dp, i+2, j), solve(a,dp, i+1, j-1));
        int y = a[j] + Math.min(solve(a, dp, i+1, j-1), solve(a, dp, i, j-2));
        dp[i][j] = Math.max(x, y);
        return dp[i][j];
    }
    
    public static int getMaximum(int[] a){
        int n = a.length;
        int[][] dp = new int[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0;j < n; j++){
                dp[i][j] = -1;
            }
        }
        
        
        return solve(a, dp, 0, n-1);
    }
    
    public static void main(String[] args) {
        int[] a = {8, 15, 3, 7};
        System.out.println(getMaximum(a));
    }
}
