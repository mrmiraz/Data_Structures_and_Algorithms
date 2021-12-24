// implementation in java recursive function

import java.util.Arrays;

public class CodeForces {

    public void find(int[] array,int low, int high, int key) {
        int mid = (low + high)/2;
        if(key < array[low] || key > array[high]){
            System.out.println(key + " is not found!");
            return;
        }
        if(array[mid] == key){
            System.out.println(key + " is found!");
            return;
        }
        else if(array[mid] < key){
            find(array, mid + 1, high, key);
        }
        else{
            find(array, low, mid - 1, key);
        }
    }

    public static void main(String[] args) {
        CodeForces cf = new CodeForces();
        int[] array = {25, 36, 1, 8, 12, 3};
        Arrays.sort(array);
        cf.find(array, 0, array.length - 1, 6);
    }
}

// implementation in java normal

import java.util.Arrays;

public class CodeForces {

    public void find(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < array[mid] || key > array[high]) {
                System.out.println(key + " is not found!");
                return;
            }
            if (array[mid] == key) {
                System.out.println(key + " is found!");
                return;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        CodeForces cf = new CodeForces();
        int[] array = {25, 36, 1, 8, 12, 3};
        Arrays.sort(array);
        cf.find(array, 36);
    }
}