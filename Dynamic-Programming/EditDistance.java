/*
Problem: Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
1. Insert a character
2. Delete a character
3. Replace a character

Algorithm:
Step 1: Take 2d array(dp) storing min distance of each segment(initialy row0 fill with 0->m and col0 0->n)
Step 2: If two character are same of the words then dp[i][j] = dp[i-1][j-1](means need zero operation)
Step 3: Else dp[i][j] = 1+min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
Step 4: Return dp[m][n]

Time complexity: O(m*n)

Sample input:
"sunday"
"saturday"

Sample output:
3

*/

public class EditDistance {
    public static int minDistance(int[][] dp, char[] c1, char[] c2){
        int m = c1.length;
        int n = c2.length;
        for(int  i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0)dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        System.out.println(minDistance(new int[c1.length+1][c2.length+1], c1, c2));
    }
    
}
