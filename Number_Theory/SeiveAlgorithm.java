import java.util.*;
public class SeiveAlgorithm {
    
    /*
    Sieve of Eratosthenes Algorithms for finding the prime numbers
    this function will return a boolean array which represents that 
    which of the number(number is represented by the the array index)
    is prime or not in the range of 1 to n
    
    Algorithm:
    Step 1: take a boolean array of size n+1 and fill with true value
    Step 2: run a loop from 2 to sqrt(n)
    Step 3: fill all the product of i with false value except i
    
    Time Complexity: O(n*log(log(n)))
    Auxiliary Space: O(n)
    */
  
    public static boolean[] seive(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i < n; i++){
            for(int j = 2*i; j <= n; j+=i){
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
    
    public static void main(String[] args) {
        boolean[] prime = seive(100);
        for(int i =0;i < prime.length; i++){
            if(prime[i])System.out.print(i + " ");
        }
        
    }
}
