
/*
Problem:
Given an array of n elements. We need to answer q 
queries telling the sum of elements in range l to 
r in the array. Also the array is not static i.e 
the values are changed via some point update query.

Time Complexity: O(
Sample input:
arr = [1, 5, 2, 4, 6, 1, 3, 5, 7, 10]
query(3, 8);
query(1, 6);
update(8, 0);
query(8, 8);

Sample output:
Sum in range of 3 and 8 : 26
Sum in range of 1 and 6 : 21
Sum in range of 8 and 8 : 0
*/

public class SquareRootDecomposition {

    static int[] block, input;
    static int rootN, N;
    
    public static void update(int index, int newValue){
        int oldValue = input[index];
        //update value in the input array
        input[index] = newValue;
        //update block after updating value of the input array
        block[index/N] = block[index/N] - oldValue + newValue;
    }
    
    public static void preProcessed() {
        rootN = (int)Math.sqrt(N)+1;
        block = new int[rootN];
        //creating block of rootN size 
        for(int i =0; i < N; i++){
            block[i/rootN] += input[i];
        }
    }
    
    public static void query(int l, int r){
        int sum  = 0;
        for(int i = l; i <= r;){
            //if the range belongs to in any block
            if(i%rootN == 0 && (i+rootN-1) <= r){
                sum += block[i/rootN];
                i += rootN;
            }
            else{
                sum += input[i];
                i++;
            }
        }
        
        System.out.println("Sum in range of "+ l + " and "+ r + " : "+ sum );
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
        N = arr.length;
        input = arr;
        preProcessed();
        query(3, 8);
        query(1, 6);
        update(8, 0);
        query(8, 8);
        
    }
}

