package datastructures.graphs;

public class TestGraphUsingAdjacencyMatrix {

    public static void main(String[] args) {
        GraphUsingAdjacentMatrix list = new GraphUsingAdjacentMatrix(5);
        list.addEdge(1, 2);
        list.addEdge(1, 3);
        list.addEdge(1, 4);
        list.addEdge(2, 4);
        list.addEdge(2, 5);
        list.addEdge(3, 4);
        list.addEdge(4, 5);

        System.out.println(list);
    }
}
