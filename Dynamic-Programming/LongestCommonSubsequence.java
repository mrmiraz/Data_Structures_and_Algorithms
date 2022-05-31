/*
Finding Longest Common Subsequence

Step 1: Take a 2d array (dp[size(s1)+1][size(s2)+1]
Step 2: Set 0 for first row and first column
Step 3: Run loop over the dp's row and column
Step 4: If s1[i-1] == s2[j-1] the dp[i][j] = 1+dp[i][j]
        else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
Step 5: Return the last value of dp

Time Complexity: O(M*N)

Sample Input:
"AGGTAB"
"GXTXAYB"

Sample Output:
4
*/
public class LongestCommonSubsequence {
    
    
    public static int backTrack(int[][] dp, char[] c1, char[] c2, int x, int y){
        if(x == 0 || y == 0)return 0;
        if(dp[x][y] != -1)return dp[x][y];
        if(c1[x-1] == c2[y-1]){
            dp[x][y] = 1 + backTrack(dp, c1, c2, x-1, y-1);
        }
        else {
            dp[x][y] = Math.max(backTrack(dp, c1, c2, x-1, y), backTrack(dp, c1, c2, x, y-1));
        }
        return dp[x][y];
    }
  
    //recursion solution 
    public static int lcsRecursion(int[][] dp, char[] s1, char[] s2, int x, int y){
        for(int i =0; i <= x; i++){
            for(int j = 0; j <= y; j++){
                if( i == 0 || j == 0)dp[i][j] = 0;
                else 
                    dp[i][j] = -1;
            }
        }
        return backTrack(dp, s1, s2, x, y);
    }
    
    //Tabular solution
    public static int lcsTabular(int[][] dp, char[] s1, char[] s2){
        int m = dp.length;
        int n = dp[0].length;
        for(int i =1; i < m ;i++){
            for(int j = 1;j < n; j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        char[] s2 = X.toCharArray();
        char[] s1 = Y.toCharArray();
        int m = s1.length, n = s2.length;
        int[][] dp = new int[m+1][n+1];
//        System.out.println(lcs(dp, s1, s2));
        System.out.println(lcsRecursion(dp,s1, s2, m, n));
    }
}
