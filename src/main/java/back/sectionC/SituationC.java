package back.sectionC;

import front.Styles;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.AbstractEdge;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.graphicGraph.GraphicEdge;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SituationC {


    //  Map<C,Array<N>> - every C node connected to N's array.
    private static Map<Integer, ArrayList<Integer>> C_to_N_Hash = new HashMap<>();
    private static Map<Integer, ArrayList<String>> map_C_pointers = new HashMap<>();
    private static Graph graph1;
    //  Set where we pull out every 2 Integers and
    //  connecting them with every C node.
    private Set<Integer> connected_I_nodes = new HashSet<>();
    //  Map with all sub-graphs that I need.
    private Map<Integer, ArrayList<Integer>> Split_Sub_Graphs = new HashMap<>();
    public int IndependentNodes, Clique;
    Graph graph = new SingleGraph("Situation_C");
    Styles styles = new Styles();
//    static Edge edge = new Graph();

    public static void main(String[] args) {
        SituationC situationC = new SituationC();
        situationC.CreateGraph(6, 3);
        System.out.println("How much Triangle sub-graphs we need -> " + situationC.getSubGraphTriangles(10, 5));
        System.out.println("How much Sticks-n-Dots sub-graphs we need -> " + situationC.getSubGraphStickAndDots(10, 5));

        situationC.search_All_two_matches();
        situationC.paintGraph(situationC.IndependentNodes);
//        edge.setAttribute("ui.style", "fill-color: rgb(200,100,205);");

    }


    public void CreateGraph(int IndependentNodes, int Clique) {
        this.IndependentNodes = IndependentNodes;
        this.Clique = Clique;

        for (int k = 0; k < Clique; k++) {
            C_to_N_Hash.put(k, getRandomNumber(IndependentNodes, 2));// putting numbers into each key
            C_to_N_Hash.get(k).sort(Comparator.naturalOrder()); // sort numbers
            System.out.println("C" + k + " ->" + C_to_N_Hash.get(k));

        }

    }


    // Numbers of triangle sub-graphs in graph
    public Integer getSubGraphTriangles(int IndependentNodes, int Clique) {
        return (2 * IndependentNodes - Clique) / 3;
    }

    // Numbers of ticks and dots sub-graphs in graph/
    public Integer getSubGraphStickAndDots(int IndependentNodes, int Clique) {
        return (2 * Clique - IndependentNodes) / 3;
    }

    //    In here we get random numbers between min and max.
    public int Randomizer(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    //    In here I put random numbers in to arraylist and then
    //    return it to method CreateGraph.
    public ArrayList<Integer> getRandomNumber(int max, int min) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random randomGenerator = new Random();
//        int sizeOfList = randomGenerator.nextInt();
        int size = ThreadLocalRandom.current().nextInt(min, max); // new random from 2 elements

        while (numbers.size() < size) {

            int random = randomGenerator.nextInt(max);
//            int random2 = randomGenerator.nextInt(max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
//            if (numbers.size() <= 1 && !numbers.contains(random2)) {
//                numbers.add(random2);
//            }
        }

        return numbers;
    }

    //    public void search_All_two_matches(Map<Integer, ArrayList<Integer>> C_to_N_Hash) {
    private Map.Entry<Integer, ArrayList<String>> makePair(ArrayList<Integer> object, int key) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < object.size() - 1; i++) {
            for (int j = i + 1; j < object.size(); j++) {
                String s = object.get(i).toString() + "-" + object.get(j).toString();
                arrayList.add(s);
            }
        }
        Map.Entry<Integer, ArrayList<String>> mapOfPairs = new AbstractMap.SimpleEntry<>(key, arrayList);
        return mapOfPairs;
    }

    public void search_All_two_matches() {
        Map<Integer, ArrayList<String>> mapOfPairs = new HashMap<>();
        int check = 0;
        int g = 0;
        for (Integer i = 0; i < C_to_N_Hash.size(); i++) {
            if (C_to_N_Hash.get(i).size() <= 1) {
                g = i;
                check = C_to_N_Hash.get(i).size();

                System.err.println("NODE C" + i + " CONTAINS ONLY 1 I ->" + C_to_N_Hash.get(i));
//                System.exit(0);
                break;


            } else {
                System.out.println("||");
                System.out.println(C_to_N_Hash.get(i));
                System.out.println(makePair(C_to_N_Hash.get(i), i));
                mapOfPairs.put(makePair(C_to_N_Hash.get(i), i).getKey(), makePair(C_to_N_Hash.get(i), i).getValue());


            }
        }

        if (check == C_to_N_Hash.get(g).size()) {
            System.exit(0);
        }

        get_all_C(mapOfPairs);

    }


    public void get_all_C(Map<Integer, ArrayList<String>> mapOfPairs) {

        int needed_size_list = IndependentNodes;
        List<String> list = new LinkedList<>();
        Map<Integer, ArrayList<String>> map = mapOfPairs;

        split_and_put_into_set(list, map.get(0).get(0));
        for (int i = 0; i < map.get(0).size(); i++) {
            int k = 0;
            int cur_size = 2;
            if (list.isEmpty()) {
                split_and_put_into_set(list, map.get(0).get(i));

            }
            for (int j = 0; j < map.get(k + 1).size(); j++) {
                split_and_put_into_set(list, map.get(k + 1).get(j));

                if (list.size() % 2 != 0) {
                    deleteLast(list);
                } else if (list.size() == cur_size + 2) {
                    cur_size = cur_size + 2;
                    k++;

                }


                if (list.size() == needed_size_list) {
                    System.out.println("We founded what we needed! -> " + list);
                    i = map.get(0).size();
                    int g = 0;

                    for (int t = 0; t < list.size(); t = t + 2) {
                        System.out.println("C" + g + " -> " + list.get(t) + " " + list.get(t + 1));
                        g++;
                    }

                    break;
                }

            }
            if (list.size() == cur_size) {
                deleteAll(list);
            }

        }


    }


    public String split_and_put_into_set(List<String> list, String s) {
        String[] splitString = s.split("-");

        if (!list.contains(splitString[0])) {
            list.add(splitString[0]);
        }
        if (!list.contains(splitString[1])) {
            list.add(splitString[1]);
        }
        System.out.println(list);

        return list.get(list.size() - 1);
    }

    public void deleteLast(List<String> list) {
        list.remove(list.get(list.size() - 1));
        System.out.println(list);
    }


    public void deleteAll(List<String> list) {
        list.clear();
        System.out.println(list + "<- nothing here");
    }

    public void paintGraph(int IndependentNodes) {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
//        graph.setAutoCreate(true);
        graph.setAttribute("ui.stylesheet", styles.getStyleSheet());
        System.out.println("-----------------");
        for (int k = 0; k < IndependentNodes; k++) {
            graph.addNode("I" + k);
            graph.getNode("I" + k).setAttribute("xyz", 3, k, 2);

            System.out.println("I" + k);
        }

        for (Node n : graph) {
            System.out.println(n.getId());
//            n.addAttribute("ui.stylesheet", styles.getStyleI());
//            n.setAttribute("ui.class","node.important");
            n.setAttribute("ui.style", "fill-color: rgb(255,175,175);");
        }


        for (int i = 0; i < C_to_N_Hash.size(); i++) {
            graph.addNode("C" + i);
            for (int j = 0; j < C_to_N_Hash.get(i).size(); j++) {
//                graph.addNode("I" + C_to_N_Hash.get(i).get(j));
                System.out.println("I" + j);
                graph.addEdge("C" + i + "I" + C_to_N_Hash.get(i).get(j), "C" + i, "I" + C_to_N_Hash.get(i).get(j));
                System.out.println("C" + i + "->" + "I" + C_to_N_Hash.get(i).get(j));
            }
        }
        int g = 0;
        int l = 0;
        int u = 0;
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
//            graph.getNode("I" + l).setAttribute("xyz", 8, 3 + g, 12);
            System.out.println("Node " + "[" + u + "]" + " degree is -> " + node.getDegree());
            u++;
            g= g + 5;
            l++;
        }

//        for (Edge edge: graph){
//
//        }


        System.out.println("-----------------");


//        Edge C0I1 = graph.getEdge("C0I1");
//        System.out.println(C0I1);

        graph.display().disableAutoLayout();


//        boolean start_status = true;
//        if (start_status){
//            graph.clear();
//        }


    }

    public void CleanUp() {
//        if ()
        graph.clear();
    }


    public void action(){
        SituationC situationC = new SituationC();
        situationC.CreateGraph(8, 4);
        System.out.println("How much Triangle sub-graphs we need -> " + situationC.getSubGraphTriangles(10, 5));
        System.out.println("How much Sticks-n-Dots sub-graphs we need -> " + situationC.getSubGraphStickAndDots(10, 5));

        situationC.search_All_two_matches();
        situationC.paintGraph(situationC.IndependentNodes);
//        graph1 = graph;
//        createEmbeddedView();

    }

//    public static ViewPanel createEmbeddedView() {
//        Viewer viewer = new Viewer(graph1, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
//        ViewPanel view = viewer.addDefaultView(false);
//        view.setPreferredSize(new Dimension((int) (698 ), (int) (440)));
//        return view;
//    }
}





