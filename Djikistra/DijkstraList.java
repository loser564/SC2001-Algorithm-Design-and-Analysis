import java.util.*;

public class DijkstraList {
    private int V; // Number of vertices
    private List<List<Edge>> adj;

    class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // Create an instance of DijkstraList
        DijkstraList dijkstraList = new DijkstraList(5); // Change 5 to the number of vertices in your graph

        // Add edges to the graph
        dijkstraList.addEdge(0, 1, 4);
        dijkstraList.addEdge(0, 2, 1);
        dijkstraList.addEdge(1, 3, 1);
        dijkstraList.addEdge(2, 1, 2);
        dijkstraList.addEdge(2, 3, 5);
        dijkstraList.addEdge(3, 4, 3);

        // Perform Dijkstra's algorithm to compute shortest distances from vertex 0
        int[] distances = dijkstraList.dijkstra(0);

        // Print the computed distances
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Shortest distance from vertex 0 to vertex " + i + ": " + distances[i]);
        }
    }

    public DijkstraList(int V) {
        this.V = V;
        this.adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        adj.get(from).add(new Edge(to, weight));
    }

    public int[] dijkstra(int start) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        minHeap.add(new Edge(start, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            int u = current.to;

            for (Edge neighbor : adj.get(u)) {
                int v = neighbor.to;
                int w = neighbor.weight;

                if (distances[u] != Integer.MAX_VALUE && distances[u] + w < distances[v]) {
                    distances[v] = distances[u] + w;
                    minHeap.add(new Edge(v, distances[v]));
                }
            }
        }
        return distances;
    }
}
