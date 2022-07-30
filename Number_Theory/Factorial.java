/*
Problem:
Finding factorial of a number
*/
public class Factorial {
    public static int fact(int n){
        int res = 1;
        for(int i = 1; i <= n; i++){
            res = res * i;
        }
        return res;
    }
    
    // recursive solution of finding fact
    public static int factRec(int n){
        if(n == 1)return 1;
        return n*factRec(n-1);
    }
    
    //store all factorial in a range of n
    public static void factStore(int n){
        int[] fact = new int[n+1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = fact[i-1]*i;
        }
        for(int i = 0; i <= n; i++){
            System.out.print(fact[i] + " ");
        }
    }
    public static void main(String[] args){
        System.out.println(factRec(4));
        factStore(5);
    }
}
