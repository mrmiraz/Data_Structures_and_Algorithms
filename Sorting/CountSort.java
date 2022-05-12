/*
 Sorting an array in ascending order with Count sort algorithm
*/
public class CountSort {
    public static void countSort(int[] arr){
        int max = arr[0];
        int n = arr.length;
        
        //finding the maximum value
        for(int i =0; i < n; i++){
            max = Math.max(max, arr[i]);
        }
        
        //counting number of occurence of each element and element is the index of the countArr
        int countArr[] = new int[max+1];
        for(int i = 0; i < n; i++){
            countArr[arr[i]] += 1;
            
        }
        
        for(int i = 1; i <= max; i++){
            countArr[i] += countArr[i-1];
        }   
        
        int outputArr[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            outputArr[--countArr[arr[i]]] = arr[i];
        }
        
        // copy the value to the original array
        for(int i = 0; i < n; i++){
            arr[i] = outputArr[i];
        }
    }
    
    public static void main(String[] args) {
        int[] array = {0,1, 1, 3, 7, 9, 2, 15, 14};
        countSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
