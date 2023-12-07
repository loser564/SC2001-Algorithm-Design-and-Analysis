public class appList {
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
}
