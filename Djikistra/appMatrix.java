public class appMatrix {
    public static void main(String[] args) {
        int[][] customGraph = {
            {0, 3, 0, 0, 0},
            {3, 0, 1, 0, 0},
            {0, 1, 0, 7, 5},
            {0, 0, 7, 0, 2},
            {0, 0, 5, 2, 0}
        };

        int startVertex = 0;
        DijkstraList dijkstraList = new DijkstraList(5);
        //DijkstraMatrix.DijkstraMatrix(customGraph, startVertex);
    }
}

