
/*
problem:
Given an array arr[] of size N. There are two types of operations: 

Update(l, r, x) : Increment the a[i] (l <= i <= r) with value x.
Query(l, r) : Find the sum in the array in a range l to r (both are included).
Examples: 
 
*/
import static java.lang.Math.*;
import java.lang.*;
public class LazyPropagationSegmentTree {
    static int[] tree, prop, arr;
    static int n;
    public static void init(int node, int b, int e){
       if(b == e){
           tree[node] = arr[b-1];
           return;
       } 
       int left = node*2, right = node*2+1;
       int mid = (b+e)/2;
       init(left, b, mid);
       init(right, mid+1, e);
       tree[node] = tree[left]+tree[right];
    }
    
    //update in a given range
    public static void update(int node, int b, int e, int lb, int rb, int newValue){
        if(b > rb || e < lb){
            return;
        }
        if(b >= lb && e <= rb){
            prop[node] += newValue;
            tree[node] += newValue*(e-b+1);
            return;
        }
        int left = node*2, right = node*2+1;
        int mid = (b+e)/2;
        update(left, b, mid, lb, rb, newValue);
        update(right, mid+1, e, lb, rb, newValue);
        tree[node] = tree[left]+tree[right]+ prop[node]*(e-b+1);
    }
    
    public static int query(int node, int b, int e, int lb, int rb, int totalProbValue){
        if(b > rb || e < lb){
            return 0;
        }
        if(b >= lb && e <= rb){
            return tree[node]+totalProbValue*(e-b+1);
        }
        int left = node*2, right = node*2+1;
        int mid = (b+e)/2;
        return query(left, b, mid, lb, rb, totalProbValue+prop[node]) + query(right, mid+1, e, lb, rb, totalProbValue+prop[node]);
    }
    
    public static int getSum(int lb, int rb){
        return query(1, 1, n, lb+1, rb+1, 0);
    }
    
    public static void updateInRange(int lb, int rb, int newValue){
        update(1, 1, n, lb+1, rb+1, newValue);
    }
    public static void createSegmentTree(int[] arr){
        n = arr.length;
        int x = (int)ceil(log(n)/log(2));
        int maxSize = 2*(1<<x);
        tree = new int[maxSize];
        prop = new int[maxSize];
        init(1, 1, n);
        
    }
    
    public static void main(String[] args){
//        int[] a = {4, -9, 3, 7, 1, 0, 2};
//        arr = a;
//        createSegmentTree(arr);
//        updateInRange(1, 7, 2);
//        updateInRange(1, 4, 3);
//        System.out.println(getSum(1, 7));
//        System.out.println(getSum(1, 4));
        int a[] = {1, 3, 5, 7, 9, 11};
        arr =a;
        createSegmentTree(arr);
        System.out.println(getSum(1, 3));
        updateInRange(1, 5, 10);
        System.out.println(getSum(1,3));
    }
}
