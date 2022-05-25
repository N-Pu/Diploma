package back;

import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class MainClass {
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.CreateGraph(graph.Randomizer(5, 30), graph.Randomizer(5, 30));

    }
}
