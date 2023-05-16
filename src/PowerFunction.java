//Problem Constraints
//        -109 <= A <= 109
//        0 <= B <= 109
//        1 <= C <= 109
//
//
//        Input Format
//        Given three integers A, B, C.
//
//
//        Output Format
//        Return an integer.
//
//
//        Example Input
//        Input 1:
//        A = 2
//        B = 3
//        C = 3
//        Input 2:
//
//        A = 3
//        B = 3
//        C = 1
//
//
//        Example Output
//        Output 1:
//        2
//        Output 2:
//
//        0
//
//
//        Example Explanation
//        Explanation 1:
//        23 % 3 = 8 % 3 = 2
//        Explanation 2:
//
//        33 % 1 = 27 % 1 = 0


public class PowerFunction {
    public long fastPower(long a ,long b,long c){
        long res = 1;
        while(b>0){
            if((b & 1) != 0 ){//if b is odd
                res = (res % c * a % c) % c;//last 2/2 is 1 even for even no. so control goes here and u'll get latest value
            }
            a = (a % c* a % c)%c;
            b=b>>1;//b/2(result is int)
        }
        return res;
    }
//we will multiply at each step as a^2 mod n = (a*a)mod n=(a mod n * a mod n)mod n
    //doing mod on small value is less computive task that's why we used formula
    //use bitwise operator coz it takes less time than multiplication and division operator
   // here complexity is o(logb)in binary search  else if u do simply multiolication then o(b)
    //we ttok long coz if a,b,c takes higher int range then int result can't be fitted with answer,so res is long


    //https://youtu.be/CnPreli2F-E
}
