# Algorithm-and-Theory-Design

Algorithm

Graph Algorithms in Java

This project is a simple Java-based implementation of graph algorithms using an adjacency list. It supports reading graphs from files, and includes common graph traversal techniques and cycle detection.

What It Does
• Builds a graph using a HashMap as an adjacency list.
• Reads graph data from a file using Scanner.
• Implements BFS and DFS for graph traversal.
• Checks if a graph is cyclic or acyclic using DFS and sink elimination.

Example Outputs
Acyclic Graph
DFS Visited: [1, 2, 4, 3]
Result: Graph is acyclic
Cyclic Graph
DFS Visited: [1, 2, 5, 3, 1]
Cycle Detected: [1, 2, 5, 3, 1]
Result: Graph is cyclic

Performance
• Time: O(V + E)
• Space: O(V)
• Works well on small to medium graphs. For massive graphs, other methods like Tarjan’s or Kahn’s algorithm might be better.

Note:-
O(V + E) is Big-O notation that describes the time complexity of graph algorithms like DFS and BFS.
Here's what it means:
• V = number of vertices (nodes) in the graph
• E = number of edges (connections) between nodes

So, O(V + E) means the algorithm will take time proportional to the total number of nodes plus the total number of edges.
This is considered efficient, especially for sparse graphs (where not every node is connected to every other node).
