public class BubbleSort {
    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSort(int arr[]){
        int l = arr.length;
        for(int i =0; i < l; i++){
            for(int j = 0; j < l-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(j, j+1, arr);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
