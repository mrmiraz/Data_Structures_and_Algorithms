public class BinaryExponentiation {
    static long mod = (long)1e9+7;
    
    //can calculate any power base 2
    static int pow(int a, int b){
        return 1<<b;
    }
    
    // log(n) time needs to calculate a^b
    static int powr(int a, int b){
        int res = 1;
        while(b > 0){
            if((b&1) == 1)res *= a;
            a = a*a;
            b = b>>1;
        }
        return res;
    }
    
    // calculate the modulo value of big number like 2^200, 10 ^ 75 so on..
    static long modularBinary(long a, long b){
        long res = 1;
        while(b > 0){
            if((b&1) == 1)res= res*a; res = res%mod;
            a = a*a; a = a%mod;
            b = b>>1;
        }
        return res;
    }
}
