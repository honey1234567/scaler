public class Paircount {
//    Input 1:
//
//    A = [1,2,3,2,1]
//    B = 5
//    Input 2:
//
//    A = [1,1,1]
//    B = 2
//
//
//    Example Output
//    Output 1:
//
//            2
//    Output 2:
//
//            3
    public int solve(int[] A, int B) {
        int count = 0;
        for(int i = 0;i<A.length;i++){
            for(int j = i+1;j<A.length;j++){
                if((A[i]+ A[j]) == B){
                    count++;
                }
            }
        }
        return count;
//
//        You are given an integer array A and an integer B.
//
//                You are required to return the count of pairs having sum equal to B.
//
//        NOTE: pair (i,j) and (j,i) are same. so run 2nd loop from i+1 coz we dont want to agin go back with i-1 elemnt
    }
}
