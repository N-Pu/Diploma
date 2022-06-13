package back.sectionB;

import front.Styles;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SituationB {

    ArrayList<ArrayList<Integer>> upList = new ArrayList<>();
    Random random = new Random();
    static int IndependentNodes = 2;
    static int Clique = 4;
    Set<String> C_Set = new HashSet<>();
    Graph graph = new SingleGraph("Situation_B");
    Styles styles = new Styles();


    public static void main(String[] args) {


        SituationB situationB = new SituationB();

        situationB.fillUpArrayWithRandomNums(IndependentNodes, Clique);

        situationB.paintGraph(situationB.upList);
    }

    public void fillUpArrayWithRandomNums(int IndependentNodes, int Clique) {

        for (int i = 0; i < IndependentNodes; i++) {
            ArrayList<Integer> inList = new ArrayList<>();
            for (int k = 0; k < Clique; k++) {
                inList.add(random.nextInt(2));
                System.out.println(inList);
                System.out.println("UPLIST->" + upList);
            }
            upList.add(inList);
            System.out.println("UP ---" + upList);
            for (ArrayList<Integer> integers : upList) {
                System.out.println(integers);
            }
        }
    }

    public void paintGraph(ArrayList<ArrayList<Integer>> upList) {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        graph.setAttribute("ui.stylesheet", styles.getStyleSheet());

        for (int k = 0; k < IndependentNodes; k++) {
            graph.addNode("I" + k);
            graph.getNode("I" + k).setAttribute("xyz", 3, k, 2);
        }

        for (Node n : graph) {
            System.out.println(n.getId());
            n.setAttribute("ui.style", "fill-color: rgb(255,175,175);");
        }
        for (int k = 0; k < IndependentNodes; k++) {
            for (int i = 0; i < upList.get(k).size(); i++) {
                if (upList.get(k).get(i) == 1) {
                    if (!checkForC("C" + i)) {
                        graph.addNode("C" + i);
                    }
                    graph.addEdge("I" + k + "C" + i, "I" + k, "C" + i);
                    System.out.println("I" + k + "C" + i);

                }
            }
        }
        int u = 0;
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
            System.out.println("Node " + "[" + u + "]" + " degree is -> " + node.getDegree());
            u++;

        }

        graph.display();
    }


    public boolean checkForC(String s) {
        int past_size = C_Set.size();
        C_Set.add(s);
        int size = C_Set.size();
        return past_size == size;

    }

}
