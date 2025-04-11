
// S.Mohanaranjan
// 20200607

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CyclicPart {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean[] recursionStack;
    static int[] parent;

    public static void main(String[] args) {
        File file = new File("/Users/shanmugaratnammohanaranjan/Desktop/Test_20200607/Text.txt");

        try {
            Scanner sc = new Scanner(file);

            int n = sc.nextInt();
            int m = sc.nextInt();

            adj = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            recursionStack = new boolean[n + 1];
            parent = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
            }

            final boolean isAcyclic = !isCyclic();

            System.out.println(isAcyclic ? "acyclic" : "cyclic");

            if (!isAcyclic) {
                ArrayList<Integer> cycle = getCycle();
                for (int i = 0; i < cycle.size(); i++) {
                    System.out.print(cycle.get(i));
                    if (i != cycle.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isCyclic() {
        for (int i = 1; i < adj.length; i++) {
            if (!visited[i] && isCyclicUtil(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(int v) {
        visited[v] = true;
        recursionStack[v] = true;

        for (int i = 0; i < adj[v].size(); i++) {
            int u = adj[v].get(i);
            if (!visited[u] && isCyclicUtil(u)) {
                parent[u] = v;
                return true;
            } else if (recursionStack[u]) {
                parent[u] = v;
                return true;
            }
        }

        recursionStack[v] = false;

        return false;
    }

    public static ArrayList<Integer> getCycle() {
        ArrayList<Integer> cycle = new ArrayList<Integer>();
        boolean[] inCycle = new boolean[visited.length];
        int u = -1, v = -1;

        for (int i = 1; i < parent.length; i++) {
            if (parent[i] != 0 && !inCycle[i]) {
                u = i;
                v = parent[i];
                break;
            }
        }

        while (!inCycle[u]) {
            cycle.add(u);
            inCycle[u] = true;
            u = parent[u];
        }

        cycle.add(u);

        return cycle;
    }
}
