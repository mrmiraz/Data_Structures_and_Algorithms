/*
Finding longest increasing subsequence from a number array
Step 1: Traversed all the value of the array left to right
Step 2: Go through all the left value of current position
Step 3: Find weather the value is smaller and has bigger or equal lis value
        if found such a element then update list value for the current number
Step 4: return maximum value from the lis array
Time complexity: O(n^2)

Sample Input:
10, 22, 9, 33, 21, 50, 41, 60
Sample output:
5
*/

public class LongestIncreasingSubsequence {
    
    public static int lis(int[] a){
        int max = 0;
        int l = a.length;
        int[] lis = new int[l];
        for(int i =0; i < l; i++){
            for(int j = 0; j < i; j++){
                //if left value is smaller and my current lis value is smaller or equal
                if(a[i] > a[j] && lis[i] <= lis[j]){
                    lis[i] =  1 + Math.max(lis[i], lis[j]);
                }
            }
            //Finding the maximum among all lis
            max = Math.max(lis[i], max);
        }
        return max+1;
    }
    
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lis(arr));
    }
}
