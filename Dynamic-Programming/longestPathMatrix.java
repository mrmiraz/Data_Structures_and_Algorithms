/*
Problem: Given a n*n matrix where all numbers are distinct, 
find the maximum length path (starting from any cell) such that
all cells along the path are in increasing order with a difference of 1. 
We can move in 4 directions from a given cell (i, j), i.e., 
we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that
the adjacent cells have a difference of 1.

Algorithm:
Step 1: We calculate longest path beginning with every cell. 
Step 2:Once we have computed longest for all cells, we return maximum of all longest paths.

Time Complexity: O(n^2)

Sample input:
matrix = [[ 1, 2, 9 ],
        [ 5, 3, 8 ], 
        [4, 6, 7 ] ];

Sample output: 
4

*/

public class LongestPathMatrix {
    
    public static int max(int a, int b, int c, int d){
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
    
    public static int findLongestFromCell(int[][] mat, int[][] dp,int i,int j, int n){
        
        // when array out of index
        if(i < 0 || i >= n || j < 0 || j >= n){
            return 0;
        }
        
        //already visited
        if(dp[i][j] != -1)return dp[i][j];
        
//        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
        int a = 0, b = 0, c = 0, d = 0;
        //go to left adjacent
        if(j > 0 && (mat[i][j]+1)== mat[i][j-1]){
            a = findLongestFromCell(mat, dp, i, j-1, n);
        }
        //go to up adjacent
        if(i > 0 && (mat[i][j]+1) == mat[i-1][j]){
            b = findLongestFromCell(mat, dp, i-1, j, n);
        }
        
        // go to right adjacent
        if(j < n-1 && (mat[i][j]+1) == mat[i][j+1]){
            c = findLongestFromCell(mat, dp, i, j+1, n);
        }
        
        //go to bottom adjacent
        if(i< n-1 && (mat[i][j]+1) == mat[i+1][j]){
            d = findLongestFromCell(mat, dp, i+1, j, n);
        }
        dp[i][j] = 1 + max(a, b, c,d);
        return dp[i][j];
        
    }
    
    public static int findLongestSum(int[][] mat){
        int n = mat.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        int result = 1;
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] == -1){
                    findLongestFromCell(mat, dp, i, j, n);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int mat[][]
            = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
        System.out.println(findLongestSum(mat));
    }
}
