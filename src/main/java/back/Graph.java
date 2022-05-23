package back;

import java.util.Map;
import java.util.Vector;

public class Graph {

    Map<String, Boolean> graph; // = new HashMap<>();
    Vector<String> nodesI = new Vector<>();
    Vector<String> nodesC = new Vector<>();




    public void CreateGraph(int IndependentNodes, int Clique) {

        for (int k = 0; k < IndependentNodes; k++) {
            nodesI.addElement("I" + k);
            System.out.println(nodesI);
        }

        for (int j = 0; j < Clique; j++) {
//            System.out.println(nodesC.add("C" + j));
            nodesC.addElement("C" + j);
            System.out.println(nodesC);
        }


//        for (int i = 0; i < IndependentNodes; i++) {
//            graph.put("C" + i + 1, new Vector<String>().add("I" + i));
//        }
//
//        for (int i = 0; i < Clique; i++) {
//            graph.put("I" + i + 1, new Vector<String>().add("C" + i));

//        graph.put("C1",new Vector<String>().add("I1"));


        }
    }

