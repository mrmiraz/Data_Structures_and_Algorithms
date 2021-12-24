//implimentation with java

public class CodeForces {

    public void mergeSort(int[] array, int lb, int ub) {
        if (lb < ub) {
            int mid = (ub + lb) / 2;
            mergeSort(array, lb, mid);
            mergeSort(array, mid + 1, ub);
            merge(array, lb, mid, ub);
        }

    }

    public void merge(int[] array, int lb, int mid, int ub) {
        int[] result = new int[array.length];
        int i = lb, j = mid+1, k = lb;
        while(i <= mid && j <= ub){
            if(array[i] < array[j]){
                result[k] = array[i];
                i++;
            }
            else{
                result[k] = array[j];
                j++;
                
            }
            k++;
        }
        // copying remaining value
        if(i > mid){
            while(j <= ub){
                result[k] = array[j];
                j++;k++;
            }
        }
        else{
            while(i <= mid){
                result[k] = array[i];
                i++;k++;
            }
        }
        // copying number of result array to array
        for(i = lb; i <= ub; i++){
            array[i] = result[i];
        }
    }
    public static void main(String[] args) {
        CodeForces cf = new CodeForces();
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        cf.mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}