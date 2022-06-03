package back.sectionC;

import java.io.IOException;
import java.util.*;

public class SituationC {


    //  Map<C,Array<N>> - every C node connected to N's array.
    private static Map<Integer, ArrayList<Integer>> C_to_N_Hash = new HashMap<>();
    private static Map<Integer, ArrayList<Integer>> Copy_C_to_N_Hash = new HashMap<>();
    //  Set where we pull out every 2 Integers and
    //  connecting them with every C node.
    private Set<Integer> connected_I_nodes = new HashSet<>();
    //  Map with all sub-graphs that I need.
    private Map<Integer, ArrayList<Integer>> Split_Sub_Graphs = new HashMap<>();
    private int IndependentNodes, Clique;

    public static void main(String[] args) {
        SituationC situationC = new SituationC();
        situationC.CreateGraph(6, 3);
        System.out.println("How much Triangle sub-graphs we need -> " + situationC.getSubGraphTriangles(10, 5));
        System.out.println("How much Sticks-n-Dots sub-graphs we need -> " + situationC.getSubGraphStickAndDots(10, 5));
//        situationC.search_All_two_matches(C_to_N_Hash);
        situationC.search_All_two_matches(C_to_N_Hash);

    }


    public void CreateGraph(int IndependentNodes, int Clique) {
        this.IndependentNodes = IndependentNodes;
        this.Clique = Clique;

        for (int k = 0; k < Clique; k++) {
            C_to_N_Hash.put(k, getRandomNumber(IndependentNodes));// putting numbers into each key
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

    //    public void search_All_two_matches(Map<Integer, ArrayList<Integer>> C_to_N_Hash) {
    private Map.Entry<Integer, ArrayList<String>> makePara(ArrayList<Integer> object, int key) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < object.size() - 1; i++) {
            for (int j = i + 1; j < object.size(); j++) {
                String s = object.get(i).toString() + object.get(j).toString();
                arrayList.add(s);
            }
        }
        Map.Entry<Integer, ArrayList<String>> res = new AbstractMap.SimpleEntry<Integer, ArrayList<String>>(key, arrayList);
        return res;
    }

    public void search_All_two_matches(Map<Integer, ArrayList<Integer>> C_to_N_Hash) {
        Map<Integer, ArrayList<String>> res = new HashMap<Integer, ArrayList<String>>();
        for (Integer i = 0; i < C_to_N_Hash.size(); i++) {
            if (C_to_N_Hash.get(i).size() <= 1) {
                System.err.println("NODE C" + i + " CONTAINS ONLY 1 I" + C_to_N_Hash.get(i));
                break;

            } else {
                System.out.println("||");
                System.out.println(C_to_N_Hash.get(i));
                System.out.println(makePara(C_to_N_Hash.get(i), i));
                res.put(makePara(C_to_N_Hash.get(i), i).getKey(), makePara(C_to_N_Hash.get(i), i).getValue());
            }
        }
    }
}

//    public  put_all_2_matches_in_every_Copy_Map


//    public void createObject(ArrayList<Integer> arrayOfI) {
//        Set<ArrayList<Integer>> set = new HashSet<>();
//        set.add(arrayOfI);
//    }




