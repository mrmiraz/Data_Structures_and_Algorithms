package sorting;

/*
Problem:
Given an array and a number k where k is smaller than the size of the array, we need to find the k’th smallest element in the given array. 
It is given that all array elements are distinct.

Sample input:
arr = [12, 3, 5, 7, 4, 19, 26]
k = 3
Sample output:
5
*/
public class OrderStatistics {

    public static int kthSmallest(int arr[], int l, int r, int k) {
        if (l > r) {
            return Integer.MAX_VALUE;
        }
        int pos = randomPartition(arr, l, r);
        if (pos == (k - 1)) {
            return arr[pos];
        } else if (pos > (k - 1)) {
            return kthSmallest(arr, l, pos - 1, k);
        } else {
            return kthSmallest(arr, pos + 1, r, k);
        }
    }

    public static int randomPartition(int arr[], int l, int r) {
        int n = r - l + 1;
        int pivot = (int) (l + Math.random() % n);
        swap(arr, pivot, r);
        return partition(arr, l, r);
    }

    public static int partition(int arr[], int l, int r) {
        int left = l - 1;
        int pivot = r;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, ++left, i);
            }
        }
        swap(arr, ++left, pivot);
        return left;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int n = kthSmallest(arr, 0, arr.length - 1, 4);
        System.out.println(n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
