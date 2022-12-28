
import  java.util.*;
import java.lang.*;
import java.io.*;
public class CointChange {

    public static int getWays(int[] coins, int sum){
        int rows = coins.length +1;
        int cols = sum +1;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for(int j = 1; j < cols; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(coins[i-1] <= j){
                    //sum generate with current new coin
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else{
                    //sum generate without current new coin
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //last top left value represent number of ways generate the sum
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args){
        int[] coins = {1, 2, 3, 5};
        int sum = 7;
        Scanner sc = new Scanner(System.in);
        System.out.println("Available coins: ");
        for(int i = 0; i < coins.length; i++){
            System.out.print(coins[i] + " ");
        }
        System.out.println("\nTotal sum to make: "+sum);
        System.out.println("The number of ways to make sum " + getWays(coins, sum));

    }
}
