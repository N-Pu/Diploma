package back;

import java.util.*;

public class Graph {

    private Map<String, ArrayList<Integer>> map = new HashMap<>();

    //    GRAPH CREATE WITH RANDOMIZER
    //    Each key contains arrayList with integers in it
    public void CreateGraph(int IndependentNodes, int Clique) {


        for (int k = 0; k < IndependentNodes; k++) {
            map.put("I" + k, getRandomNumber(Clique));
            System.out.println("I" + k + " ->" + map.get("I" + k));

        }

    }

    //    In here we get random numbers between min and max
    public int Randomizer(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    //    In here I put random numbers in to arraylist and then
    //    return it to method CreateGraph
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


}

