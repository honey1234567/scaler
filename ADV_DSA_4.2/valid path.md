<img width="334" alt="image" src="https://github.com/user-attachments/assets/edd99e22-6e5b-40d0-986c-1d4248689800" />

<img width="319" alt="image" src="https://github.com/user-attachments/assets/f64a648f-7386-4fe6-8066-633539415aaf" />

<img width="329" alt="image" src="https://github.com/user-attachments/assets/0aca04a2-7bba-44f3-83c9-71e6677b8b9c" />

<img width="343" alt="image" src="https://github.com/user-attachments/assets/adc87dee-6eac-4a90-ab2d-a10489a10052" />

<img width="331" alt="image" src="https://github.com/user-attachments/assets/cafb8b50-0e54-4f03-b707-2b4bdb1208ab" />

## solution
Check if (i,j) is a valid point for all 0<=i<=x, 0<=j<=y. By valid point we mean that none of the circle should contain it.

To do this you can simply check for all points (i,j) where 0<=i<=x, 0<=j<=y if there is a circle on which this point.
If a point lies on a circle it should satisfy that circle’s equation.((i-a)^2+(j-b)^2==r^2 where (a,b) is the centre of the circle and r is its radius)

Now you know all the valid point in rectangle. You need to figure out if you can go from (0,0) to (x,y) through valid points. This can be done with any graph traversal algorithms like BFS/DFS.

DFS ( i , j )
mark (i,j) as visited
for all (i’,j’) positions to where we can travel to from (i,j)
DFS(i’,j’)

Now we just have to check if (x,y) is visited or not. If it is visited then output YES otherwise NO.

public class Solution {
    private boolean isInsideCircle(int x, int y, int centerX, int centerY, int radius) {
        if ((((x - centerX)* (x - centerX))) + (((y - centerY) *(y - centerY))) <= (radius * radius))
            return true;
        else
            return false;
    }

    int[] indxI = {0, 1, 0, -1, -1, -1, 1, 1};
    int[] indxJ = {1, 0, -1, 0, -1, 1, -1, 1};

    public boolean dfs(int[][] grid, int[][] visited, int st, int en, int finxIdx, int finyIdx){
    
if(grid[st][en] == -1) return false;
        visited[st][en] = -1;

        if(st == finxIdx && en == finyIdx){
            return true;
        }

        for(int i = 0; i < 8; i++){
            int newSt = st + indxI[i];
            int newEn = en + indxJ[i];
            if(newSt >= 0 && newSt < grid.length && newEn >= 0 && newEn < grid[0].length && visited[newSt][newEn] != -1 ){
                if(dfs(grid, visited, newSt, newEn, finxIdx, finyIdx)){
                    return true;
                }
            }
        }
       
        return false;
    }

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] grid = new int[A+1][B+1];
        int[][] visited = new int[A+1][B+1];

        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < C; k++) {
                    if (isInsideCircle(i, j, E.get(k), F.get(k), D)) {
                        grid[i][j] = -1;//point which lie inside any of circle mark -1
                        break;
                    }
                }
            }
        }

        if(dfs(grid, visited, 0, 0, A, B)){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}




