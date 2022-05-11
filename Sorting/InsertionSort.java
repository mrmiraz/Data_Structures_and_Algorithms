/*
Sorting an array with insertion sort algorithm in ascending order
*/
public class InsertionSort {
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void insertionSort(int[] arr){
        int length = arr.length;
        
        for(int i =0; i < length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
                else break;
            }
        }
        
        
    }public static void main(String[] args) {
        
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
