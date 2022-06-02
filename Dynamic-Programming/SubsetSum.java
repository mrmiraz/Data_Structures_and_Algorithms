
package dynamicprogramming;
/*
Given a set of non-negative integers, and a value sum, determine 
if there is a subset of the given set with sum equal to given sum. 

Algorithm(Tabular):
Step 1: Take 2d boolean array (dp[n+1][sum+1]) which will record wheather sum is possible or not
Step 2: If element is not include then dp[i][j] = dp[i-1][j]
Step 3: Element is include if element is smaller than sum then,
        dp[i][j] = dp[i][j] || dp[i-1][sum - element]
Step 4: Return last value of the 2d array which will determine sum is possible or not

Time Complexity: O(m*sum)

Sample input:
arr = [3, 34, 4, 12, 5, 2]
sum = 30

Sample output:
false

*/
import java.util.Arrays;

public class SubsetSum {
    
    //recursion solution 
    public static boolean isSubsetSumRec(int[] set, int n, int sum){
        if(n == 0)return false;
        if(sum == 0)return true;
        if(set[n-1] > sum){
            return isSubsetSumRec(set, n-1, sum);
        }
        return isSubsetSumRec(set, n-1, sum-set[n-1]) || isSubsetSumRec(set, n-1, sum);
    }
    
    // Tabular Solution
    public static boolean isSubsetSumTab( int[] set, int sum){
         int length = set.length;
         boolean[][] dp = new boolean[length+1][sum+1];
         //zero element can not generate >0 sum
         Arrays.fill(dp[0], false);
         
         //any kinds of set can generate 0 sum
         for(int i = 0; i <= length; i++){
             dp[i][0] = true;
         }
         
         //Fill the table with possible gennerated sum with subsets
         for(int i = 1; i <= length; i++){
             for(int j = 1; j <= sum; j++){
                 // element is not including(take upper value)
                 dp[i][j] = dp[i-1][j];
                 int element = set[i-1];
                 if(element <= j){
                     //element is including
                     dp[i][j] = dp[i][j] || dp[i-1][j - element];
                 }
             }
         }
         
         return dp[length][sum];
    }
    
    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 30;
        int n = set.length;
        System.out.println(isSubsetSumRec(set,n,sum));
        System.out.println(isSubsetSumTab(set,sum));
    }
}
