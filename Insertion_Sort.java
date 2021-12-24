// implementation in java in accending order

public class CodeForces {

    public void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int right = i;
            while(right > 0 && array[right] < array[right - 1]){
                swap(array, right, right -1);
                right--;
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        CodeForces cf = new CodeForces();
        int[] array = {1, 1, 3, 7, 9, 2, 15, 14};
        cf.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}