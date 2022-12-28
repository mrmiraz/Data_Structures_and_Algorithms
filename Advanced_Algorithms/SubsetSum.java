import java.util.Arrays;

public class SubsetSum {

    public static boolean isPossibleSubsetSum(int[] coins, int sum){
        int rows = coins.length+1;
        int cols = sum+1;
        boolean[][] dp = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            dp[i][0] = true;
        }
        for(int j = 1; j < cols; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-coins[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {

        int[] coins = {1, 3, 4, 7, 10};
        int sum = 8;

        System.out.print("Coins are: ");
        for(int i = 0; i < coins.length; i++){
            System.out.print(coins[i] + ",");
        }
        System.out.println("\nSum is: "+ sum);
        if(isPossibleSubsetSum(coins, sum)){
            System.out.println("Subset sum is possible.");
        }
        else{
            System.out.println("Subset sum is not possible");
        }
    }
}
