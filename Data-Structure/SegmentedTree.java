

/*
Problem:
Let us consider the following problem to understand Segment Trees.
We have an array arr[0 . . . n-1]. We should be able to 

Find the sum of elements from index l to r where 0 <= l <= r <= n-1
Change value of a specified element of the array to a new value x. We need to do arr[i] = x where 0 <= i <= n-1.
Time Complexity: 

Time Complexity for tree construction is O(n). There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.
Time complexity to query is O(Logn). To query a sum, we process at most four nodes at every level and number of levels is O(Logn). 
The time complexity of update is also O(Logn). To update a leaf value, we process one node at every level and number of levels is O(Logn).
*/
public class SegmentedTree {
    static int[] tree, arr;
    public static void init(int node, int b, int e){
        if(b == e){
            tree[node] = arr[b];
            return;
        }
        int left = node*2, right = node*2+1;
        int mid = (b+e)/2;
        init(left, b, mid);
        init(right, mid+1, e);
        tree[node] = tree[left]+tree[right];
    }
    
    public static int query(int node, int b, int e, int lb, int rb){
        if(b > rb || e < lb)return 0;
        if(b >= lb && e <= rb){
            return tree[node];
        }
        int left = node*2, right = node*2+1;
        int mid = (b+e)/2;
        return query(left, b, mid, lb, rb) + query(right, mid+1, e, lb, rb);
    }
    
    public static void update(int node, int b, int e, int index, int value){
        if(b > index || e < index)
            return;
        if(b >= index && e <= index){
            tree[node] = value;
            return;
        }
        int left = node*2, right = node*2+1;
        int mid = (b+e)/2;
        update(left, b, mid, index, value);
        update(right, mid+1, e, index, value);
        tree[node] = tree[left]+tree[right];
    }
    
    public static void main(String[] args){
        int n = 7;
        int[] a ={0, 4, -9, 3, 7, 1, 0, 2};
        arr = a;
        tree = new int[n*3];
        init(1, 1, n);
        System.out.println(query(1, 1, n, 1, 7));
        update(1, 1, n, 5, 5);
        System.out.println(query(1, 1, n, 1, 7));
    }
}
