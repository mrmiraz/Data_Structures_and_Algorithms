// implementation in java

import java.util.Arrays;

public class CodeForces {

    public void find(int[] array, int a) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                System.out.println(a + " is found!");
                return;
            }
        }
        System.out.print(a + " is not found!");
    }

    public static void main(String[] args) {
        CodeForces cf = new CodeForces();
        int[] array = {25, 36, 1, 8, 12, 3};
        cf.find(array, 36);
    }
}