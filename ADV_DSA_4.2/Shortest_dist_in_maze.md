![image](https://github.com/user-attachments/assets/7d16d846-ff33-42e3-8709-23eb288ffb45)


![image](https://github.com/user-attachments/assets/5c273f05-69b2-4faf-96d7-fd27a4aff680)


![image](https://github.com/user-attachments/assets/ba5e7b67-1b4d-46a9-b274-6581bb2ea7b0)


![image](https://github.com/user-attachments/assets/044fc541-6ab8-4e88-8de5-e37a2b603842)

## Solution 
The problem is a variation of standard dijkstra algorithm.
Here, suppose the ball is at {x, y}. We will try all possible 4 directions and construct a weighted edge using simple traversal.

Once we have calculated the weighted edge, we can simply use standard dijkstra algorithm to continue.
We will repeat the above procedure until we reach the destination.

For implementation details, kindly refer to complete solution.
public class Solution {
   private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static class Point {
        int row, col,dist;

        Point(int row, int col,int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int solve(int[][] maze, int[] src, int[] dest) {
        int n = maze.length, m = maze[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(src[0], src[1],0));
        dist[src[0]][src[1]] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
           if(cur.dist>dist[cur.row][cur.col]) continue;
        
            for (int d = 0; d < 4; d++) {
                int r = cur.row, c = cur.col, steps = 0;

               
                while (isValid(r + DX[d], c + DY[d], maze)) {
                    r += DX[d];
                    c += DY[d];
                    steps++;
                }
                if (dist[cur.row][cur.col] + steps < dist[r][c]) {
                    dist[r][c] = dist[cur.row][cur.col] + steps;
                    queue.offer(new Point(r, c,dist[r][c]));
                }
            }
        }

        int result = dist[dest[0]][dest[1]];
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private boolean isValid(int r, int c, int[][] maze) {
        return r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] == 0;
    }
}

## note 
       1)  queue.offer(new Point(src[0], src[1],0));

          //in queue store location and distance needed to reach to that location
          
   
         2)  if(cur.dist>dist[cur.row][cur.col]) continue;
           //skip route if through some other path we found a better path to reach to the current location
       
           3) //update distyance in queue of that cell if prevously was not minimum
                if (dist[cur.row][cur.col] + steps < dist[r][c]) {
               }
