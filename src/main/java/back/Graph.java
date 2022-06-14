package back;

import java.util.*;
import java.util.stream.Collectors;

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
        return (2 * IndependentNodes - Clique) / 3;
    }

    // Numbers of ticks and dots sub-graphs in graph/
    public Integer getSubGraphStickAndDot(int IndependentNodes, int Clique) {
        return (2 * Clique - IndependentNodes) / 3;
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


    //  checking if keys were already used
    public boolean isKeyNotUsed(String firstKey, String secondKey) {

        return !usedKeys.contains(firstKey) && !usedKeys.contains(secondKey);
    }

    //  add keys in queue for checking them
    public void keysAddedInQueue(String firstKey, String secondKey) {
        usedKeys.add(firstKey);
        usedKeys.add(secondKey);
    }

}



