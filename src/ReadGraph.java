
// S.Mohanaranjan
// 20200607

import java.util.*;

public class ReadGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public ReadGraph(int edges) {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {

        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> getAdjacentVertices(int vertex) {

        return adjacencyList.get(vertex);
    }

    public void removeEdge(int source, int destination) {
        List<Integer> sourceNeighbors = adjacencyList.get(source);
        if (sourceNeighbors != null) {
            sourceNeighbors.remove(Integer.valueOf(destination));
        }
    }

    public void removeVertex(int vertex) {
        adjacencyList.values().stream().forEach(list -> list.remove(Integer.valueOf(vertex)));
        adjacencyList.remove(vertex);
    }

    public int size() {

        return adjacencyList.size();
    }

    public int getNumNodes() {
        return adjacencyList.keySet().size();
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = adjacencyList.get(vertex);
        if (neighbors == null) {
            return new ArrayList<Integer>();
        } else {
            return neighbors;
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int vertex : adjacencyList.keySet()) {
            builder.append(vertex).append(": ");
            for (int neighbor : adjacencyList.get(vertex)) {
                builder.append(neighbor).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
