/*
Problem:Given three numbers x, y and p, compute (xy) % p. 
Time Complexity: O(log(b))
Space Complexity: O(1)
*/
public class BinaryExponentiation {
    //power of a^b
    public static int power(int a, int b){
        int res = 1;
        while(b > 0){
            if((b&1) == 1)res = res*a;
            a = a*a;
            b = b >> 1;
        }
        return res;
    }
    
    // power of a number with modulo operation 
    public static int power(int a, int b, int mod){
        int res = 1;
        while(b > 0){
            if((b&1) == 1)res = (res*a)%mod;
            a = (a*a)%mod;
            b = b>>1;
        }
        return res;
    }
    
    public static void main(String[] args){
        System.out.println(power(4, 2));
        System.out.println(power(2, 5, 13));
    }
}
