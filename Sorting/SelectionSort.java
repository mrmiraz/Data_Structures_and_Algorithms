/*
Sorting an array with Selection Sort algorithm in ascending order
*/
public class SelectionSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i; j < length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            
            swap(arr, i, index);
        }
    }

    public static void main(String[] args) {

        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
