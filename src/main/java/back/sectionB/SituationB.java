package back.sectionB;

import front.Styles;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.*;

public class SituationB {

    ArrayList<ArrayList<Integer>> upList = new ArrayList<>();
    Random random = new Random();
    static int IndependentNodes = 8;
    static int Clique = 16;
    Set<String> C_Set = new HashSet<>();
    Graph graph = new SingleGraph("Situation_B");
    Styles styles = new Styles();
    List<Integer> listOfDots = new LinkedList<>();
    List<Integer> listOfSticks = new LinkedList<>();
    List<Integer> listOfAllComponents = new LinkedList<>();
    List<Integer> blockList = new LinkedList<>();


    public static void main(String[] args) {

        SituationB situationB = new SituationB();
        situationB.fillUpArrayWithRandomNums(IndependentNodes, Clique);
        situationB.paintGraph(situationB.upList);
        situationB.getR();
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

//    public void GetAllSubGraphs() {
//        listOfDots.clear();
//        listOfSticks.clear();
//
//        for (int i = 0; i < upList.size(); i++) {
//            int checkDot = 0;
//            int checkStick = 0;
//            for (int j = 0; j < upList.get(i).size(); j++) {
//                if (upList.get(i).get(j) == 0 && checkDot == 0) {
//                    if (CheckForUsedDotes(j))
//                        checkDot++;
//
//                } else {
//                    if (CheckForUsedSticks(j) && checkStick == 0) {
//                        checkStick++;
//                    }
//                }
//                if (checkDot == 1 && checkStick == 1) {
//                    j = upList.get(i).size();
//                }
//            }
//            if (checkDot == 0 || checkStick == 0) {
//                System.err.println("ALL 0/1 IN ONE ARRAY!!! ");
//                break;
//            }
//        }
//        System.out.println("ALL DOTS   -> " + listOfDots);
//        System.out.println("ALL STICKS -> " + listOfSticks);
//    }

    public boolean CheckForUsedDotes(int number) {
        if (!listOfDots.contains(number)) {
            listOfDots.add(number);
            System.out.println("DOTS -> " + listOfDots);
            return true;
        }
        return false;
    }

    public boolean CheckForUsedSticks(int number) {
        if (!listOfSticks.contains(number)) {
            listOfSticks.add(number);
            System.out.println("STICKS -> " + listOfSticks);
            return true;
        }
        return false;
    }


    public void getR() {
        listOfDots.clear();
        listOfSticks.clear();
        listOfAllComponents.clear();


        for (int i = 0; i < upList.size(); i++) {
            int checkDot = 0;
            int checkStick = 0;
            for (int j = 0; j < upList.get(i).size(); j++) {
                if (upList.get(i).get(j) == 0 && checkDot == 0) {
                    if (CheckForAll(j)) {
                        if (blockList.isEmpty()) {
                            checkDot++;
                            listOfDots.add(j);
                            blockList.add(j);
                            System.out.println("D ->" + listOfDots);

                        }
                    }
                }
                if (upList.get(i).get(j) == 1 && checkStick == 0) {
                    if ((CheckForAll(j))) {
                        checkStick++;
                        listOfSticks.add(j);
                        System.out.println("S ->" + listOfSticks);
                    }
                }
                if (checkDot == 1 && checkStick == 1) {
                    break;
                }
            }
            if (checkDot == 0 || checkStick == 0) {
                System.err.println("Didn't find any matches!!! ");
                blockPosition(i);
                i = 0;

            }
        }
        System.out.println("ALL DOTS   -> " + listOfDots);
        System.out.println("ALL STICKS -> " + listOfSticks);
    }


    public boolean CheckForAll(int number) {
        if (!listOfAllComponents.contains(number)) {
            listOfAllComponents.add(number);
            System.out.println("ALL -> " + listOfAllComponents);
            return true;
        }
        return false;
    }

    public boolean blockPosition(int number) {
        if (blockList.contains(number)) {
            return true;
        }
        return false;

    }

}
