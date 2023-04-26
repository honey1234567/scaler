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
