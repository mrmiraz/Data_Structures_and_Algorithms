/**
 *if current sum is negative then assign current sum = 0
 */
public class KadensAlgorithm {
    
    public static int maxSumArray(int a[]){
        int max_sum = a[0], cur_sum = 0;
        for(int i = 0; i < a.length; i++){
            cur_sum = cur_sum + a[i];
            if(cur_sum > max_sum)max_sum = cur_sum;
            if(cur_sum < 0) cur_sum = 0;
        }
        return max_sum;
    }
    
    public static void main(String[] args) {
        int a[] = {5, -4, -2, 6, -1};
        System.out.print(maxSumArray(a));
    }
}
