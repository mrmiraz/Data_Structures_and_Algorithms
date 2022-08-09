import java.util.Arrays;

/*
Problem: Find next permutation 

Algorithm:
Step 1: Search last and find value which is smaller than right value(pivot index)
Step 2: Then search nearest greater value from that pivot index to last index and swap thos two value
Step 3: reverse or sort the arr form pivotIndex to last index

Time complexity: O(n^2)
Space complexity: O(1)

Input: 
arr = [1, 2, 3, 6, 5, 4]

Output:
1 2 4 3 5 6

*/
public class NextPermutation {
    public static int findNearestGreater(int arr[], int sIndex, int eIndex){
        for(int i = eIndex; i > sIndex; i--){
            if(arr[i] > arr[sIndex]){
                return i;
            }
        }
        return sIndex;
    }
    
    public static void reverse(int arr[], int sIndex, int eIndex){
        while(sIndex < eIndex){
            int t = arr[sIndex];
            arr[sIndex] = arr[eIndex];
            arr[eIndex] = t;
            sIndex++;eIndex--;
        }
    }
    
    public static void nextPermutation(int arr[]){
        int len = arr.length;
        for(int i = len-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
//                System.out.println(i);
                int ngIndex = findNearestGreater(arr, i, len-1);
//                System.out.println(ngIndex);
                int t = arr[ngIndex];
                arr[ngIndex] = arr[i];
                arr[i] = t;
//                reverse(arr, i+1, len-1); 
                Arrays.sort(arr, i+1, len);
                return;
            }
        }
        Arrays.sort(arr);
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 5, 4};
        nextPermutation(a);
        for(int i: a){
            System.out.print(i + " ");
        }
    }
}
