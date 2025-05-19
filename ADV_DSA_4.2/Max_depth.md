## Problem
<img width="402" alt="image" src="https://github.com/user-attachments/assets/1be2a6ea-713b-46ad-b75d-b522622145a8" />

![image](https://github.com/user-attachments/assets/91991497-3d02-4fdb-8b86-e7379066aa31)

![image](https://github.com/user-attachments/assets/95911da3-314e-46dc-8500-e530efcca162)

![image](https://github.com/user-attachments/assets/ed90a7d0-018e-47d2-a043-8846c7adb243)

![image](https://github.com/user-attachments/assets/07254f2c-dbf2-4129-82f6-27108e3ae8f9)

<img width="381" alt="image" src="https://github.com/user-attachments/assets/03fc3876-a9e7-414e-aa4c-13983c36455d" />

![image](https://github.com/user-attachments/assets/b4a8bff3-ec67-4a34-8a65-636a7255dab4)

## SOlution Approach
Main idea is to maintain list of nodes at every different level.

Can we do that with dfs or bfs?

To maintain the list, Call dfs from the root of tree(1) and insert the node at in the list at particularr level.

For each query, Use binary search to find the required value at a particular level.

If there is no value present which is greater or equal to x, output -1.

![image](https://github.com/user-attachments/assets/2f8718ce-2e01-4876-874e-7fc40b0d46f4)

Prepare adjacency list of levels which are connected
Add level   1 in queue
Iterate queue size in level order traversal and
make Hashmat of key level and array of value lies at that level
Sort the values of that level before moving to next level iteration
Apply BS on sorted values at each level for each query

## Code(BFS +BS)

public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F) {
       
        ArrayList<ArrayList<Integer>> adjList = new ArrayList();
        for(int i=0; i<=A; i++) {
            adjList.add(new ArrayList<>());

        }
        for(int i=0; i<B.size(); i++) {
            adjList.get(B.get(i)).add(C.get(i));
            adjList.get(C.get(i)).add(B.get(i));
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[A+1];
        int level = 0;
        queue.add(1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int x = queue.poll();
                vis[x] = true;
                if(map.containsKey(level)) {
                    map.get(level).add(D.get(x-1));
                }else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(D.get(x-1));
                    map.put(level, temp);
                }
                if(adjList.get(x).size()==0) continue;
                for(int j=0; j<adjList.get(x).size(); j++) {
                    int l = adjList.get(x).get(j);
                    if(!vis[l]) queue.add(l);
                }
            }
            Collections.sort(map.get(level));
            level++;
        }
        ArrayList<Integer> ans = new ArrayList();
        for(int i=0; i<E.size(); i++) {
            ans.add(binarySearch(map.get(E.get(i)%level), F.get(i)));
        }
        return ans;
    }
    private int binarySearch(ArrayList<Integer> list, int target) {
        int ans = -1;
        int low = 0, high = list.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(list.get(mid)>=target) {
                ans=list.get(mid);
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    
    }
}









