/*
Problem: lets a, b, c the numbers
and 0 <= a <= b <= c <= 10^15
show the  value of (a*b)%c = ?
*/

public class FastMultiplication {
    
    //normal multiplication of two number
    static int multiply(int a , int b){
        int res = 0;
        while(b > 0){
            if((b&1) == 1)res = res + a;
            a = a+a;
             b = b >> 1;
        }
        return res;
    }
    
    static long modularMulty(long a , long b, long c){
        long res = 0;
        while(b > 0){
            if((b&1) == 1){
                res = res + a;
                res = res%c;
            }
            a = 2*a;a = a%c;
            b = b>>1;
        }
        return res;
    }
    
}
