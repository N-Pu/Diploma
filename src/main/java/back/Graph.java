package back;

import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class Graph {

    Map<String, Boolean> graph; // = new HashMap<>();
    Vector<String> nodes = new Vector<>();

    public Graph(Map<String, Boolean> graph) {
        this.graph = graph;
    }


    public void CreateGraph(int IndependentNodes, int Clique) {

        Random random = new Random();
        random.ints(13);

        for (int i = 0; i < IndependentNodes; i++) {
            graph.put("C" + i + 1, new Vector<String>().add("I" + i + 1));
        }

        for (int i = 0; i < Clique; i++) {
            graph.put("I" + i + 1, new Vector<String>().add("C" + i + 1));
        }

//        graph.put("C1",new Vector<String>().add("I1"));

    }

}
