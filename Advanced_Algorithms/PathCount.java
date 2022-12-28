import java.util.Scanner;

public class PathCountProblem {

    /*
    * return total possible path
    * moving constraints:
    * 1. Can move right
    * 2. Can move bottom
    * */
    public static int countPath(int rows, int cols){
        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            dp[i][0] = 1;
        }

        for(int j = 1; j < cols; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter cols: ");
        int cols = sc.nextInt();

        System.out.println("Total possible path: "+countPath(rows, cols));
    }
}
