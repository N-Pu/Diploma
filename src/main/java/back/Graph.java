package back;


import java.util.*;

public class Graph {

    //    My HashMap that contains keys as I's
    //    and vectors as C's.
    private Map<String, ArrayList<Integer>> map = new HashMap<>();
    private int IndependentNodes, Clique;


    //    GRAPH CREATE WITH RANDOMIZER
    //    Each key contains arrayList with integers in it
    public void CreateGraph(int IndependentNodes, int Clique) {
        this.IndependentNodes = IndependentNodes;
        this.Clique = Clique;

        for (int k = 0; k < IndependentNodes; k++) {
            map.put("I" + k, getRandomNumber(Clique));
            System.out.println("I" + k + " ->" + map.get("I" + k));

        }

    }

    // Numbers of triangle sub-graphs in graph
    public Integer getSubGraphTriangle(int IndependentNodes, int Clique) {
        return (2 * IndependentNodes - Clique);
    }

    // Numbers of ticks and dots sub-graphs in graph/
    public Integer getSubGraphStickAndDot(int IndependentNodes, int Clique) {
        return (2 * Clique - IndependentNodes);
    }


    //    In here we get random numbers between min and max.
    public int Randomizer(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    //    In here I put random numbers in to arraylist and then
    //    return it to method CreateGraph.
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


    public void CompareArraysForSectionC(Map<String, ArrayList<Integer>> map) {
        this.map = map;
//        boolean allNodesArePassed = true;
        int NodeIChecker, NodeCChecker = 0;

        Map<String, ArrayList<Integer>> copyMap = map;
        Vector<Integer> copyINodes = new Vector<>(IndependentNodes);

        int triangles = getSubGraphTriangle(IndependentNodes, Clique); // numbers of triangles


//
        for (int k = 0; k < IndependentNodes; k++) {
            copyINodes.add(k, k);
        }

        while (triangles != 0) {

            for (int i = 0; i < map.size(); i++) {
                ArrayList<Integer> currentArray = map.get("I" + i);
                for (int j = 0; j < currentArray.size(); j++) {
                    currentArray.get(i).
                }
            }

            triangles--;
        }

    }
}
