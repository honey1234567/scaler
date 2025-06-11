## quesion - compute ncrmodp

public class Solution {
 public int solve(int A, int B, int C) {
        int nfactorial = factorial(A,C);
        int rfactorial = factorial(B,C);
        long rpow=getPower(rfactorial,C-2,C);
        int nrfactorial = factorial(A-B,C);
        long nrpow = getPower(nrfactorial,C-2,C);
        
        return (int) ((((nfactorial%C)*(rpow%C))%C*(nrpow%C))%C)%C;
    }

    int factorial(int n, int p){
        long fact=1;
        for(int i=2;i<=n;i++){
            fact= (fact*i%p)%p;
        }
        return (int)fact;
    }

    int getPower(int A, int B, int C){
        if (B==0)
            return 1;
        
        long sa = getPower(A,B/2,C);
        long p = ((sa%C)*(sa%C))%C;
        if(B%2 == 0){
            return (int) p;
        }
        return (int) ((A*p)%C);
    }
}
