<img width="452" height="253" alt="image" src="https://github.com/user-attachments/assets/56fc55a1-8258-4470-afdb-b63feebc5b1a" />

<img width="452" height="253" alt="image" src="https://github.com/user-attachments/assets/057b33e2-3fc3-407c-8d4f-3b893a6a6fd7" />

<img width="452" height="231" alt="image" src="https://github.com/user-attachments/assets/90774c85-f19e-4f63-9c14-925637622918" />

Replace child with text subtree<img width="468" height="50" alt="image" src="https://github.com/user-attachments/assets/03773525-d2f2-492b-99cf-4965b29cf5ef" />

<img width="452" height="233" alt="image" src="https://github.com/user-attachments/assets/1ee40767-de2d-47f0-8258-ef913721e7c7" />

<img width="452" height="250" alt="image" src="https://github.com/user-attachments/assets/ecdd6447-e951-4a73-9980-865782d3fa93" />

## java code 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoints {

    private int time; // Global timer for discovery times
    private int[] tin; // Discovery time of each node
    private int[] low; // Lowest discovery time reachable from a node (or its descendants)
    private boolean[] visited;
    private List<Integer> articulationPoints;
    private ArrayList<ArrayList<Integer>> adj;

    public ArticulationPoints(int V) {
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        tin = new int[V];
        low = new int[V];
        visited = new boolean[V];
        articulationPoints = new ArrayList<>();
        time = 0;
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public List<Integer> findArticulationPoints() {
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(i, -1); // -1 indicates no parent for the root of the DFS tree
            }
        }
        return articulationPoints;
    }

    private void dfs(int u, int parent) {
        visited[u] = true;
        tin[u] = low[u] = time++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) {
                continue; // Skip the parent
            }

            if (visited[v]) {
                // Back-edge found
                low[u] = Math.min(low[u], tin[v]);
            } else {
                // Tree-edge found
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                // Check if u is an articulation point
                if (low[v] >= tin[u] && parent != -1) {
                    // If low[v] >= tin[u], it means no back-edge from v or its descendants
                    // goes to an ancestor of u, making u an articulation point
                    if (!articulationPoints.contains(u)) { // Avoid duplicates
                        articulationPoints.add(u);
                    }
                }
                children++;
            }
        }

        // Special case for the root of the DFS tree
        if (parent == -1 && children > 1) {
            if (!articulationPoints.contains(u)) { // Avoid duplicates
                articulationPoints.add(u);
            }
        }
    }

    public static void main(String[] args) {
        ArticulationPoints graph = new ArticulationPoints(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        List<Integer> aps = graph.findArticulationPoints();
        System.out.println("Articulation Points: " + aps); // Expected: [2, 3]
    }
}
<img width="451" height="699" alt="image" src="https://github.com/user-attachments/assets/b9ac013b-154b-494e-a26c-2e05605cc0b1" />

## Bridges

<img width="582" height="273" alt="image" src="https://github.com/user-attachments/assets/2ebf3db4-d18e-49ef-9567-c4befc45cea3" />

<img width="628" height="427" alt="image" src="https://github.com/user-attachments/assets/da5b8067-58a0-4a42-b5e6-5d72a74860fd" />
