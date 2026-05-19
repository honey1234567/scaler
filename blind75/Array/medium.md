https://neetcode.io/problems/anagram-groups/solution

https://neetcode.io/problems/top-k-elements-in-list/solution

https://neetcode.io/problems/string-encode-and-decode/solution

Here’s a compact **Java syntax + Data Structures cheat sheet** focused on **competitive programming / coding interviews**.

---

# 1. Arrays

## Declare

```java
int[] arr = new int[5];
int[] arr2 = {1, 2, 3, 4};
```

## Input

```java
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int[] arr = new int[n];

for(int i = 0; i < n; i++) {
    arr[i] = sc.nextInt();
}
```

## Traverse

```java
for(int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

for(int x : arr) {
    System.out.println(x);
}
```

## Sort

```java
Arrays.sort(arr);
```

Descending for primitive array:

```java
Integer[] a = {4, 1, 7};

Arrays.sort(a, (x, y) -> y - x);
```

---

# 2. ArrayList

## Declare

```java
ArrayList<Integer> list = new ArrayList<>();
```

## Operations

```java
list.add(10);
list.add(20);

list.get(0);

list.set(1, 50);

list.remove(0);

list.size();

list.contains(50);
```

## Traverse

```java
for(int x : list) {
    System.out.println(x);
}
```

## Sort

```java
Collections.sort(list);

Collections.sort(list, Collections.reverseOrder());
```

---

# 3. String

## Important Methods

```java
String s = "hello";

s.length();

s.charAt(0);

s.substring(1, 4);

s.equals("hello");

s.contains("ell");

s.indexOf('e');

s.toCharArray();
```

## Reverse String

```java
StringBuilder sb = new StringBuilder(s);

sb.reverse();

String rev = sb.toString();
```

---

# 4. StringBuilder

Very important for CP.

```java
StringBuilder sb = new StringBuilder();

sb.append("abc");

sb.append(10);

sb.deleteCharAt(0);

sb.reverse();

sb.toString();
```

---

# 5. HashMap

## Declare

```java
HashMap<Integer, Integer> map = new HashMap<>();
```

## Operations

```java
map.put(1, 10);

map.get(1);

map.getOrDefault(5, 0);

map.containsKey(2);

map.remove(1);
```

## Frequency Map

```java
for(int x : arr) {
    map.put(x, map.getOrDefault(x, 0) + 1);
}
```

## Traverse

```java
for(Map.Entry<Integer, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " " + e.getValue());
}
```

---

# 6. HashSet

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);

set.contains(10);

set.remove(10);
```

Used for:

* duplicate removal
* O(1) lookup

---

# 7. Queue

## Queue using LinkedList

```java
Queue<Integer> q = new LinkedList<>();

q.offer(10);

q.poll();

q.peek();

q.isEmpty();
```

Used in:

* BFS
* level order traversal

---

# 8. Stack

```java
Stack<Integer> st = new Stack<>();

st.push(10);

st.pop();

st.peek();

st.isEmpty();
```

Better modern alternative:

```java
Deque<Integer> st = new ArrayDeque<>();
```

---

# 9. Deque

Very important in sliding window problems.

```java
Deque<Integer> dq = new ArrayDeque<>();

dq.offerFirst(10);

dq.offerLast(20);

dq.pollFirst();

dq.pollLast();

dq.peekFirst();

dq.peekLast();
```

---

# 10. PriorityQueue (Heap)

## Min Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

## Max Heap

```java
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>((a, b) -> b - a);
```

## Operations

```java
pq.offer(10);

pq.poll();

pq.peek();
```

Used in:

* top k
* shortest path
* heaps

---

# 11. Pair in Java

Java has no built-in pair.

## Custom Pair

```java
class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
```

Usage:

```java
Pair p = new Pair(1, 2);
```

---

# 12. Comparator

## Sort 2D Array by second column

```java
Arrays.sort(arr, (a, b) -> a[1] - b[1]);
```

## Custom Object Sorting

```java
class Student {
    int marks;

    Student(int marks) {
        this.marks = marks;
    }
}

Arrays.sort(students, (a, b) -> a.marks - b.marks);
```

---

# 13. Comparable

```java
class Student implements Comparable<Student> {

    int marks;

    Student(int marks) {
        this.marks = marks;
    }

    public int compareTo(Student other) {
        return this.marks - other.marks;
    }
}
```

---

# 14. 2D Array

```java
int[][] mat = new int[n][m];

for(int i = 0; i < n; i++) {
    for(int j = 0; j < m; j++) {
        mat[i][j] = sc.nextInt();
    }
}
```

---

# 15. Graph Adjacency List

Very common.

```java
ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

for(int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}

graph.get(u).add(v);
graph.get(v).add(u);
```

---

# 16. Fast Input (Important)

## BufferedReader

```java
BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

int n = Integer.parseInt(br.readLine());
```

## StringTokenizer

```java
StringTokenizer st =
    new StringTokenizer(br.readLine());

int a = Integer.parseInt(st.nextToken());
int b = Integer.parseInt(st.nextToken());
```

Faster than `Scanner`.

---

# 17. Useful Built-in Functions

## Arrays

```java
Arrays.sort(arr);

Arrays.fill(arr, 0);

Arrays.toString(arr);
```

## Math

```java
Math.max(a, b);

Math.min(a, b);

Math.abs(x);

Math.sqrt(x);

Math.pow(a, b);
```

---

# 18. Common Competitive Programming Patterns

## Frequency Count

```java
HashMap<Integer, Integer> freq = new HashMap<>();
```

## Two Pointer

```java
int l = 0, r = 0;
```

## Sliding Window

```java
while(r < n) {

    while(condition) {
        l++;
    }

    r++;
}
```

## BFS

```java
Queue<Integer> q = new LinkedList<>();
```

## DFS

```java
void dfs(int node) {

    vis[node] = true;

    for(int nei : graph.get(node)) {

        if(!vis[nei]) {
            dfs(nei);
        }
    }
}
```

---

# 19. Primitive vs Wrapper (VERY IMPORTANT)

| Primitive | Wrapper   |
| --------- | --------- |
| int       | Integer   |
| char      | Character |
| long      | Long      |
| double    | Double    |

Needed because:

* Collections store objects only
* Comparator needs wrapper class

Example:

```java
Integer[] arr = {1, 2, 3};
```

NOT:

```java
int[] arr
```

for custom comparator sorting.

---

# 20. Competitive Programming Template

```java
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

        }
    }
}
```

---

# Most Important DS for Interviews + CP

Focus heavily on:

1. Arrays
2. HashMap
3. HashSet
4. ArrayList
5. Stack
6. Queue
7. Deque
8. PriorityQueue
9. Graph adjacency list
10. StringBuilder

---

# Time Complexity to Remember

| DS            | Search   | Insert   | Delete   |
| ------------- | -------- | -------- | -------- |
| Array         | O(n)     | O(n)     | O(n)     |
| HashMap       | O(1) avg | O(1) avg | O(1) avg |
| HashSet       | O(1) avg | O(1) avg | O(1) avg |
| PriorityQueue | O(n)     | O(log n) | O(log n) |
| Stack         | O(1)     | O(1)     | O(1)     |
| Queue         | O(1)     | O(1)     | O(1)     |

---

# Things Beginners Forget in Java CP

* `==` vs `.equals()`
* Primitive vs Wrapper
* Integer comparator overflow:

```java
(a, b) -> Integer.compare(a, b)
```

better than:

```java
a - b
```

* `String` immutable
* Use `StringBuilder`
* `Scanner` slow for big input
* `PriorityQueue` default is min heap
* `HashMap` order not guaranteed
