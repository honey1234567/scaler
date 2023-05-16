import java.util.HashMap;
//Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
//
//        NOTE:we can't solve this through array traversal coz we need to also keep track of frq of element
//
//        Each element in the result should appear as many times as it appears in both arrays.
//        The result can be in any order.
//
//
//        Problem Constraints
//        1 <= N, M <= 105
//
//        1 <= A[i] <= 109
//
//
//
//        Input Format
//        First argument is an integer array A of size N.
//
//        Second argument is an integer array B of size M.
//
//
//
//        Output Format
//        Return an integer array denoting the common elements.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [1, 2, 2, 1]
//        B = [2, 3, 1, 2]
//        Input 2:
//
//        A = [2, 1, 4, 10]
//        B = [3, 6, 2, 10, 10]
//
//
//        Example Output
//        Output 1:
//
//        [1, 2, 2]
//        Output 2:
//
//        [2, 10]

// https://www.youtube.com/watch?v=jMwLFkI2Zbc
public class CommonElements {
    public void solve(int[] A, int[] B) {
        int l1 = A.length;
        int l2 = B.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            int freq = map.getOrDefault(A[i], 0);
            int newf = freq + 1;
            map.put(A[i], newf);
        }
        for (int i = 0; i < l2; i++) {

            int freq = map.containsKey(B[i]) ? map.get(B[i]) : 0;
            if (freq > 0) {

                int newf = freq - 1;
                map.put(B[i], newf);
                System.out.println(B[i]);
            }
        }
    }
}
