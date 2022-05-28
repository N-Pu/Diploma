package back;


public class MainClass {
    public static void main(String[] args) {

        Graph graph = new Graph();
        int getCliqueNum = graph.Randomizer(5, 30);
        int getIndependentNodesNum = graph.Randomizer(5, 30);
        graph.CreateGraph(getIndependentNodesNum, getCliqueNum);
        System.out.println("[Nodes in Clique] --> " + getCliqueNum);
        System.out.println("[Nodes in IndependentNodes] --> " + getIndependentNodesNum);

    }
}
