/*
Sorting an array with Quick Sort Algorithm in ascenlding order
*/

public class QuickSort {
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo >= hi)return;
        int q = partition(arr,lo, hi);
        quickSort(arr, lo, q-1);
        quickSort(arr, q+1, hi);
    }
    
    public static int partition(int[] arr, int lo, int hi){
        int left = lo-1, pivot = hi;
        for(int i = lo; i < hi; i++){
            if(arr[i] < arr[pivot]){
                swap(arr, i, ++left);
            }
        }
        swap(arr, ++left, pivot);
        return left;
    }
    
    public static void main(String[] args) {
        
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
