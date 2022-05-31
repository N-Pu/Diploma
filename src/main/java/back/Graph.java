package back;


import java.util.*;

public class Graph {

    //    My HashMap that contains keys as I's
    //    and vectors as C's.
    private Map<String, ArrayList<Integer>> map = new HashMap<>();
    private int IndependentNodes, Clique;

    private Queue<String> usedKeys = new ArrayDeque<>();

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
        int sizeOfList = randomGenerator.nextInt(max) + 1;

        while (numbers.size() < sizeOfList) {

            int random = randomGenerator.nextInt(max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }


    public void CompareArraysForSectionC() {
//        this.map = map;
//        boolean allNodesArePassed = true;
//        int NodeIChecker, NodeCChecker = 0;

        Map<String, ArrayList<Integer>> copyMap = map;
        Vector<Integer> copyINodes = new Vector<>(IndependentNodes);
//        Queue<String> usedKeys = new ArrayDeque<>();
        int triangles = getSubGraphTriangle(IndependentNodes, Clique); // numbers of triangles


//
        for (int k = 0; k < IndependentNodes; k++) {
            copyINodes.add(k, k);
        }

        while (triangles != 0) {

            for (int i = 0; i < copyMap.size(); i++) {
                ArrayList<Integer> currentArray = copyMap.get("I" + i);
                for (int k = 1; k < copyMap.size(); k++) {
                    ArrayList<Integer> copyOfNextArray = copyMap.get("I" + k);


                    if (isKeyNotUsed("I" + i, "I" + k) && copyOfNextArray.retainAll(currentArray)) {  //are these Inodes already were used
                        keysAddedInQueue("I" + i, "I" + k);
                        System.out.println("I" + i + " -> " + copyOfNextArray.get(0) + " -> " + "I" + k);
                        triangles--;
                        continue;
                    }

                }
            }


        }

    }

    //  checking if keys were already used
    public boolean isKeyNotUsed(String firstKey, String secondKey) {

        if (usedKeys.contains(firstKey) || usedKeys.contains(secondKey)) {
            return false;

        }

        return true;
    }

    //  add keys in queue for checking them
    public void keysAddedInQueue(String firstKey, String secondKey) {
        usedKeys.add(firstKey);
        usedKeys.add(secondKey);
    }

}



