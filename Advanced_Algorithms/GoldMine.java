import java.util.Scanner;

public class GoldMine {

    /**
     * @param goldMine an integer 2d array(gold mine)
     * @return an integer value(maximum gold mine)
     */
    public static int getMaxMine(int[][] goldMine) {
        int rows = goldMine.length;
        int cols = goldMine[0].length;
        int[][] dp = new int[rows][cols];
        int maxGoldMine = 0;

        //copy of first column of goldMine value to dp table
        for (int i = 0; i < rows; i++) {
            dp[i][0] = goldMine[i][0];
            maxGoldMine = Math.max(dp[i][0], maxGoldMine);
        }

        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int a = 0, b = 0, c;
                if ((i - 1) >= 0) a = dp[i - 1][j - 1];
                if ((i + 1) <= rows - 1) b = dp[i + 1][j - 1];
                c = dp[i][j - 1];
                dp[i][j] = Math.max(a, Math.max(b, c)) + goldMine[i][j];
                maxGoldMine = Math.max(dp[i][j], maxGoldMine);
            }
            System.out.println();
        }

        //print dp table
        System.out.println("Dp Table: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return maxGoldMine;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter cols: ");
        int cols = sc.nextInt();
        int[][] goldMine = new int[rows][cols];
        System.out.println("enter gold mine value: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                goldMine[i][j] = sc.nextInt();
            }
        }
        System.out.println("Maximum gold mine: \n" + getMaxMine(goldMine));
    }
}
/*
case 1:
4 3
1 5 12
2 4 4
0 6 4
3 0 0

case 2:
4 4
1 3 1 5
2 2 4 1
5 0 2 3
0 6 1 2
 */
