import java.util.HashMap;

//complexity- o(n)
//logic-remove nested for loop by keep storing prev elemt in map(with freq) and in the current iteration
//if counter pair(sum-a[i]) is found in map then we all increment count by freq of sum-a[i] and store a[i] in map with
//curr freq if present in map +1
//        https://youtu.be/5L9Jrehvoew
//https://www.geeksforgeeks.org/wrapper-classes-java/
//Hashmap complexity-remove: O(1)
//        size: O(1)
//        values: O(n) (on traversal through iterator)
//        Insertion is O(1) because you add the element right at the head of LinkedList.
//        Fast access time: HashMaps provide constant time access to elements, which means that retrieval and insertion of elements is very fast, usually O(1) time complexity.
public class PairCountOptimize {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int b = B-A[i];
            if(map.get(b) != null){
                count = count + map.get(b);//unboxing to int from INTeger
            }
            map.put(A[i],map.getOrDefault(A[i],0) + 1);
        }
        return count;
    }


}
////////////////////////
Approach 1

For every i run a loop of j and check if A[i]+A[j]==B or not. Also, check if i!=j.

Time complexity : O(n^2)

This is enough to pass the test casses. However we can furthur optimize this solution.

Approach 2

Sort the array A in increasing order. For each i from 0 to n-1 find the first element in the array having a value greater than or equal to B-A[i] using binary search.
(For c++ we can directly use ‘lower_bound’ function) . Now just check if this element is equal to B-A[i] , if it is then return 1 , otherwise continue the process.

Time complexity : O(nlogn)
