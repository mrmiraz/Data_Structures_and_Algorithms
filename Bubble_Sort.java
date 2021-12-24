// implementation in java in accending order

public class CodeForces {

    public void bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i -1; j++){
                if(array[j] > array[j+1] ){
                    swap(array,j,j+1);
                }
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
        cf.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}