// implementation in java in accending order

public class CodeForces {

    public void quickSort(int[] array,int lb,int ub){
        if(lb < ub){
            int q = partition(array, lb, ub);
            quickSort(array,lb, q-1 );
            quickSort(array, q+1, ub);
        }
    }
    public int partition(int[] array,int lb,int ub){
        int i = lb - 1;
        int pivot = array[ub];
        for(int j = lb; j < ub; j++){
            if(array[j] < pivot){
                i++;
                swap(array, i, j);
            }
        }
        i++;
        swap(array, i, ub);
        return i;
    }
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        CodeForces cf = new CodeForces();
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        cf.quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}