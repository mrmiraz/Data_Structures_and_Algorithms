// sorting an array with Merge Sort algorithm in ascending order
public class MergeSort {
    
    public static void partition(int[] arr, int lo, int hi){
        if(lo == hi)return;
        int mid = (lo+hi)/2;
        partition(arr, lo, mid);
        partition(arr, mid+1, hi);
        merge(arr, lo, mid, hi);
    }
    
    public static void merge(int[] arr, int lo,int mid, int hi){
        int left = lo, right = mid+1, index = 0;
        int tempArr[] = new int[hi-lo+1];
        while(left <= mid && right <= hi){
            if(arr[left] < arr[right]){
                tempArr[index++] = arr[left];
                left++;
            }
            else{
                tempArr[index++] = arr[right];
                right++;
            }
        }
        
        while(left <= mid){
            tempArr[index++] = arr[left++];
        }
        
        while(right <= hi){
            tempArr[index++] = arr[right++];
        }
        index = 0;
        for(int i = lo; i <= hi; i++){
            arr[i] = tempArr[index++];
        }
    }
    
    public static void main(String[] args) {
        
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        partition(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
