package back;

import java.util.*;

public class Graph {

    //    Map<String, Boolean> graph; // = new HashMap<>();
//    private Vector<String> nodesI = new Vector<>();
    private Vector<String> nodesC = new Vector<>();
    private Map<String, ArrayList<Integer>> map = new HashMap<>();
    private Random random = new Random();


    public void CreateGraph(int IndependentNodes, int Clique) {


        for (int k = 0; k < IndependentNodes; k++) {
//            int currentVectorSize = getRandomNumber(0, Clique);
            map.put("I" + k, getRandomNumber(Clique));
//            getRandomNumber(Clique);
//            nodesC.addElement("С" + getRandomNumber(0, currentVectorSize));
//            System.out.println(nodesC);

            System.out.println("I"+ k + " ->"+ map.get("I"+ k));


        }

//        for (int j = 0; j < Clique; j++) {
////            System.out.println(nodesC.add("C" + j));
//            nodesC.addElement("C" + j);
//            System.out.println(nodesC);
//        }
//        for (int i = 0; i < IndependentNodes; i++) {
//            graph.put("C" + i + 1, new Vector<String>().add("I" + i));
//        }
//
//        for (int i = 0; i < Clique; i++) {
//            graph.put("I" + i + 1, new Vector<String>().add("C" + i));

//        graph.put("C1",new Vector<String>().add("I1"));
    }


    public int Randomizer(int min, int max) {

        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public ArrayList<Integer> getRandomNumber(int max) {
//        int num = (int) (((Math.random() % max)));
//        Vector<Integer> numbersNotMach = new Vector<>();
//        int check = 0;
//
//        if (numbersNotMach == null) {
//            numbersNotMach.addElement(num);
//        } else
//            for (int i = 0; i < numbersNotMach.size(); i++) {
////                boolean equels = numbersNotMach.indexOf(i) == num;
//                if (numbersNotMach.indexOf(i) == num)
//                check++;
//
//            }
        ArrayList<Integer> numbers = new ArrayList<>();
//        ArrayList<String> numbersWithCinIt = new ArrayList<>();
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

