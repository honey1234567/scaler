import java.util.HashMap;
//Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//
//        If the given array contains a sub-array with sum zero return 1, else return 0.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        -10^9 <= A[i] <= 10^9
//
//
//
//        Input Format
//        The only argument given is the integer array A.
//
//
//
//        Output Format
//        Return whether the given array contains a subarray with a sum equal to 0.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [1, 2, 3, 4, 5]
//        Input 2:
//
//        A = [-1, 1]
//
//
//        Example Output
//        Output 1:
//
//        0
//        Output 2:
//
//        1
//
//
//        Example Explanation
//        Explanation 1:
//
//        No subarray has sum 0.
//        Explanation 2:
//
//        The array has sum 0.

//logic-keep storing current sum(prefix sum) till current index in map and at each index find if map contains
//currentsum-sum to find that means u got subarray
//        https://youtu.be/XzwUBIkR9pA-will only work for contigious subarray
public class SubArraySumK {
    public int solve(int[] A, int sum) {
        int n = A.length;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < n; i++) {
            currentSum = currentSum + A[i];
            int b = currentSum - sum;


           if (map.get(b) != null || b == 0) {
                return 1;
            }
            map.put(currentSum,i);
        }
        return 0;
    }

}
