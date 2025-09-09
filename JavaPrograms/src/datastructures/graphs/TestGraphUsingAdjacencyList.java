package datastructures.graphs;

public class TestGraphUsingAdjacencyList {

    public static void main(String[] args) {
        GraphUsingAdjacencyList list = new GraphUsingAdjacencyList(5);
        list.addEdge(0, 1);
        list.addEdge(0, 2);
        list.addEdge(0, 3);
        list.addEdge(1, 3);
        list.addEdge(1, 4);
        list.addEdge(2, 3);
        list.addEdge(3, 4);

        System.out.println(list);
    }
}
