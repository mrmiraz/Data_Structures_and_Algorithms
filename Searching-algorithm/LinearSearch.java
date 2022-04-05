public class LinearSearch {
    public static int linearSearch(int arr[],int x){
        int size = arr.length;
        for(int i = 0; i < size; i++){
            if(arr[i] == x)return x;
        }
        return -1;
    }
    
    public static void main(String[] args){
        int arr[] = {1, 2, 5, 8, 0, -1, 6};
        int x = linearSearch(arr, 8);
        System.out.println(x);
    }
}
