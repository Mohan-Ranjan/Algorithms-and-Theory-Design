
// S.Mohanaranjan
// 20200607

import java.util.ArrayList;
import java.util.List;

public class CycleArray {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public CycleArray(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public int V() {

        return V;
    }

    public int E() {

        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public List<Integer> adj(int v) {

        return adj[v];
    }

    public int outdegree(int v) {

        return adj[v].size();
    }

    public int indegree(int v) {
        int indegree = 0;
        for (int i = 0; i < V; i++) {
            for (int j : adj(i)) {
                if (j == v) {
                    indegree++;
                }
            }
        }
        return indegree;
    }
}
