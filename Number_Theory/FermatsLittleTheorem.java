/*
Problem:
Finding inverse of a number
*/

public class FermatsLittleTheorem {
    
    public static int gcd(int a, int b){
        if(b == 0)return a;
        return gcd(b, a%b);
    }
    
    public static int power(int a, int b, int mod){
        int res = 1;
        while(b > 0){
            if((b&1) == 1) res = (res*a)%mod;
            a = (a*a)%mod;
            b = b >> 1;
        }
        return res;
    }
    
    public static void modInverse(int a, int m){
        if(gcd(a, m) != 1){
            System.out.println("Inverse does not exist!");
        }
        else{
            System.out.println("Modular multiplicative inverse is "+ power(a, m-2, m));
        }
    }
    public static void main(String[] args){
        modInverse(3, 11);
    }
}
