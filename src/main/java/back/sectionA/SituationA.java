package back.sectionA;

import front.Styles;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;


import java.util.*;



public class SituationA {
    private int IndependentNodes, Clique;
    private static final Map<Integer, ArrayList<Integer>> C_to_N_Hash = new HashMap<>();
    Graph graph = new SingleGraph("Situation_A");
    Styles styles = new Styles();


    public void CreateGraph(int IndependentNodes, int Clique) {
        this.IndependentNodes = IndependentNodes;
        this.Clique = Clique;

        for (int k = 0; k < Clique; k++) {
            C_to_N_Hash.put(k, getRandomNumber(IndependentNodes));// putting numbers into each key
            C_to_N_Hash.get(k).sort(Comparator.naturalOrder()); // sort numbers
            System.out.println("C" + k + " ->" + C_to_N_Hash.get(k));

        }

        paintGraph(IndependentNodes);

    }

    public ArrayList<Integer> getRandomNumber(int max) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random randomGenerator = new Random();
        int sizeOfList = randomGenerator.nextInt(max);

        while (numbers.size() < sizeOfList) {

            int random = randomGenerator.nextInt(max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }


    public void paintGraph(int IndependentNodes) {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        graph.setAttribute("ui.stylesheet", styles.getStyleSheet());
        System.out.println("-----------------");
        for (int k = 0; k < IndependentNodes; k++) {
            graph.addNode("I" + k);
            System.out.println("I" + k);
        }
        int g = 0;
        int l = 0;
        for (Node n : graph) {
            System.out.println(n.getId());
            n.setAttribute("ui.style", "fill-color: rgb(200,100,205);");
            g= g + 5;
            l++;
        }


        for (int i = 0; i < C_to_N_Hash.size(); i++) {
            graph.addNode("C" + i);
            for (int j = 0; j < C_to_N_Hash.get(i).size(); j++) {
                System.out.println("I" + j);
                graph.addEdge("C" + i + "I" + C_to_N_Hash.get(i).get(j), "C" + i, "I" + C_to_N_Hash.get(i).get(j));
                System.out.println("C" + i + "->" + "I" + C_to_N_Hash.get(i).get(j));
            }
        }

        int u = 0;
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
            System.out.println("Node " + "[" + u + "]" + " degree is -> " + node.getDegree());
            u++;

        }


        System.out.println("-----------------");

       graph.display().enableAutoLayout();

    }

    public void CleanUp() {
        graph.clear();
    }
}
