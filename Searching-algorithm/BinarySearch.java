public class BinarySearch {
    
    //if there is found the given number in the array, then return the number otherwise return -1
    public static int binSearch(int arr[], int l, int r, int x){
        if(l > r)return -1;
        int mid=  l + (r-l)/2;
        
        if(arr[mid] == x){
            return x;
        }
        
        if(x < arr[mid]){
            return binSearch(arr, l, mid-1, x);
        }
        else{
            return binSearch(arr, mid+1, r, x);
        }
    }
    
    public static void main(String[] args){
        
        int arr[] = {1, 2 , 3, 4, 5,6};
        int x = binSearch(arr, 0, arr.length-1, 7);
        System.out.println(x);
    }
    
}
