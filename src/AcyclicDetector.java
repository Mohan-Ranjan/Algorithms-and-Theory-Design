
// S.Mohanaranjan
// 20200607

import java.io.*;
import java.util.*;

class AcyclicDetector {
    static class ReadGraph {
        private final int V;
        private final List<List<Integer>> adj;

        ReadGraph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int src, int dest) {

            adj.get(src).add(dest);
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            for (int i = 0; i < V; i++)
                if (isCyclicUtil(i, visited, recStack))
                    return true;

            return false;
        }

        private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
            if (recStack[v])
                return true;

            if (visited[v])
                return false;

            visited[v] = true;
            recStack[v] = true;

            List<Integer> children = adj.get(v);

            for (Integer c : children)
                if (isCyclicUtil(c, visited, recStack))
                    return true;

            recStack[v] = false;

            return false;
        }
    }

    static ReadGraph readGraphFromFile(String fileName) {
        ReadGraph graph = null;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int V = 0;
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(" ");
                int src = Integer.parseInt(values[0]);
                int dest = Integer.parseInt(values[1]);

                if (src > V)
                    V = src;
                if (dest > V)
                    V = dest;
            }

            scanner = new Scanner(file);
            graph = new ReadGraph(V + 1);
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(" ");
                int src = Integer.parseInt(values[0]);
                int dest = Integer.parseInt(values[1]);

                graph.addEdge(src, dest);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return graph;
    }



    public static void main(String[] args) {
        ReadGraph graph = readGraphFromFile("/Users/shanmugaratnammohanaranjan/Desktop/Test_20200607/Text.txt");
        boolean isAcyclic = !graph.isCyclic();
        System.out.println(isAcyclic ? "yes" : "no");


    }
}
