package datastructures.graphs;

public class TestGraphUsingEdgeList {

    public static void main(String[] args) {
        GraphUsingEdgeList list = new GraphUsingEdgeList(5);
        list.addEdge(1,2,1);
        list.addEdge(1,3,4);
        list.addEdge(1,4,2);
        list.addEdge(2,4,3);
        list.addEdge(2,5,5);
        list.addEdge(3,4,3);
        list.addEdge(4,5,2);

        System.out.println(list);

    }
}
