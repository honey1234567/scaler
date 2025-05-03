## Question

<img width="325" alt="image" src="https://github.com/user-attachments/assets/60e19d65-e9c3-4074-9fdb-fb76692c80b0" />
<img width="325" alt="image" src="https://github.com/user-attachments/assets/a29910de-f1b9-4dbd-a9c7-2a0b76676aef" />
<img width="335" alt="image" src="https://github.com/user-attachments/assets/4b884842-7cfb-49aa-9a94-f09f0085ef58" />

## Solution

public class Solution {
   
    public int solve(int[] A, final int B, final int C) {
          int n = A.length;
           List<List<Integer>> graph = new ArrayList<>();
             for(int i=0;i<=n;i++){      // Initialize the adjacency list with an empty ArrayList for each node
            graph.add(new ArrayList());
        }
        for(int i=1;i<n;i++){    // Add each directed edge to the graph
            int s= A[i];    //Source
            int d = i+1;   //destination
            graph.get(s).add(d);
        }
          return DFSpath(C,B,graph) == true ? 1 : 0;


    }
     public boolean DFSpath(int source, int target, List<List<Integer>> graph){
         if(source == target){
            return true;
        }

       List<Integer> neigh= graph.get(source); //Get all the neighbors of the current Source

        for(int n : neigh){
            if(DFSpath(n,target,graph)){
                 return true;
            }
        }
        return false;
    }

}



