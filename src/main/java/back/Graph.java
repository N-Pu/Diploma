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


    public void CompareArraysForSectionC() {
        Map<String, ArrayList<Integer>> copyMap = map;
        ArrayList<String> copyINodes = new ArrayList<>();

        int triangles = getSubGraphTriangle(IndependentNodes, Clique); // numbers of triangles

        Set<Integer> usedCNodes = new HashSet<>();


        Integer last_C_node = 0;

        for (int k = 0; k < IndependentNodes; k++) {
            copyINodes.add(k, "I" + k);
        }

        while (triangles != 0) {

            for (int i = 0; i < copyMap.size(); i++) {
                ArrayList<Integer> currentArray = copyMap.get("I" + i);
                for (int k = 1; k < copyMap.size(); k++) {
                    ArrayList<Integer> copyOfNextArray = copyMap.get("I" + k);


                    if (isKeyNotUsed("I" + i, "I" + k) && compareTwoArraysToGetNodeC(currentArray, copyOfNextArray)) {  //are these Inodes already were used

                        if (!usedCNodes.contains(returnFirstNodeC(currentArray, copyOfNextArray))) {
                            keysAddedInQueue("I" + i, "I" + k);

                            usedCNodes.add(returnFirstNodeC(currentArray, copyOfNextArray)); // copy integer C node to array of used nodesC
                            System.out.println("I" + i + " -> " + copyOfNextArray.get(0) + " -> " + "I" + k);

                            triangles--;


                            if (triangles == 1) {
                                copyINodes.removeAll(usedKeys); // we've got two keys that were not used


                                while (!usedCNodes.contains(last_C_node)) {
                                    last_C_node++;
                                }
                                map.get(copyINodes.get(0)).add(last_C_node);
                                map.get(copyINodes.get(1)).add(last_C_node);
                                System.out.println(map.get(copyINodes.get(0)) + " -> " + last_C_node + " -> " + map.get(copyINodes.get(1)));
                                triangles--;
                                i = copyMap.size();
                                k = copyMap.size();

                            }
                        }
                    }
                }

            }
        }


    }


    public boolean compareTwoArraysToGetNodeC(ArrayList<Integer> firstArrayList, ArrayList<Integer> secondArrayList) {
        Object NodeC = firstArrayList.stream().filter(secondArrayList::contains).collect(Collectors.toList());
        return true;
    }

    public int returnFirstNodeC(ArrayList<Integer> firstArrayList, ArrayList<Integer> secondArrayList) {

        return firstArrayList.stream().filter(secondArrayList::contains).collect(Collectors.toList()).get(0);
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



