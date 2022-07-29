package numbertheory;

/*
Problem:
Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!

Input
The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

Output
For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.

Example
Input:
2
1 10
3 5

Output:
2
3
5
7

3
5

*/
import java.util.*;
import java.lang.*;

public class SegmentedSeive {

    static Scanner sc = new Scanner(System.in);
    static Vector<Integer> primes = new Vector<>();
    static final int MAX = 32000;

    public static void simpleSeive() {
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        for (int i = 3; i < MAX; i += 2) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        primes.add(2);
        for (int i = 3; i < MAX; i += 2) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public static void segSeive(int low, int high) {
        boolean[] isPrime = new boolean[high - low + 1];
        Arrays.fill(isPrime, true);
        if (low == 1) {
            isPrime[0] = false;
        }
        for (int i = 0; primes.get(i) * primes.get(i) <= high; i++) {
            int curPrime = primes.get(i);
            int base = (low / curPrime) * curPrime;
            if (base < low) {
                base += curPrime;
            }
            for (int j = base; j <= high; j += curPrime) {
                isPrime[j - low] = false;
            }
            if (base == curPrime) {
                isPrime[base - low] = true;
            }
        }
        for (int i = 0; i < high - low + 1; i++) {
            if (isPrime[i]) {
                System.out.println(low + i);
            }
        }
    }

    public static void solver() {
        simpleSeive();
        int low = sc.nextInt(), high = sc.nextInt();
        segSeive(low, high);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solver();
        }
    }
}
