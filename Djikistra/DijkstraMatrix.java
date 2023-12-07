import java.util.Arrays;

public class DijkstraMatrix {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] customGraph = {
            {0, 3, 0, 0, 0},
            {3, 0, 1, 0, 0},
            {0, 1, 0, 7, 5},
            {0, 0, 7, 0, 2},
            {0, 0, 5, 2, 0}
        };

        int startVertex = 0;

        // Create an instance of DijkstraMatrix
        DijkstraMatrix dijkstraMatrix = new DijkstraMatrix();

        // Call the findShortestPaths method on the instance
        dijkstraMatrix.findShortestPaths(customGraph, startVertex);
    }

    public void findShortestPaths(int[][] graph, int start) {
        int numVertices = graph.length;
        int[] distances = new int[numVertices]; // array to store distances
        boolean[] visited = new boolean[numVertices]; // boolean to track vertices visited

        Arrays.fill(distances, INF);
        distances[start] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistance = findMinDistance(distances, visited);
            visited[minDistance] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[minDistance][j] != 0 && distances[minDistance] != INF
                        && distances[minDistance] + graph[minDistance][j] < distances[j]) {
                    distances[j] = distances[minDistance] + graph[minDistance][j];
                }
            }
        }

        // Print distance
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": Distance = " + distances[i]);
        }
    }

    private static int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = INF;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
