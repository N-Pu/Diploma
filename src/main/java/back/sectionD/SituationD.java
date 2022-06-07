package back.sectionD;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SituationD {


    //  Map<C,Array<N>> - every C node connected to N's array.
    private static Map<Integer, ArrayList<Integer>> C_to_N_Hash = new HashMap<>();
    private static Map<Integer, ArrayList<String>> map_C_pointers = new HashMap<>();
    //  Set where we pull out every 2 Integers and
    //  connecting them with every C node.
    private Set<Integer> connected_I_nodes = new HashSet<>();
    //  Map with all sub-graphs that I need.
    private Map<Integer, ArrayList<Integer>> Split_Sub_Graphs = new HashMap<>();
    private int IndependentNodes, Clique;
    private List<String> list = new LinkedList<>();
    private String todo;
    int num_to_cut = 0;
    private List<String> copy_list = new LinkedList<>();

    public static void main(String[] args) {
        SituationD situationD = new SituationD();
        situationD.CreateGraph(7, 4);
        System.out.println("How much Triangle sub-graphs we need -> " + situationD.getSubGraphTriangles(7, 4));
        System.out.println("How much Sticks-n-Dots sub-graphs we need -> " + situationD.getSubGraphStickAndDots(7, 4));
        situationD.search_All_two_matches();
        situationD.get_graph_and_cut_fictitious_node();
    }


    public void CreateGraph(int IndependentNodes, int Clique) {
        this.IndependentNodes = IndependentNodes;
        this.Clique = Clique;
        int q = 0;
        for (int k = 0; k < Clique; k++) {
            C_to_N_Hash.put(k, getRandomNumber(IndependentNodes, 2));// putting numbers into each key
            C_to_N_Hash.get(k).sort(Comparator.naturalOrder()); // sort numbers
            System.out.println("C" + k + " ->" + C_to_N_Hash.get(k));
            q = k;
        }
        String pos = Integer.toString(q);
        getNumForCut(pos);

//        get_graph_and_cut_fictitious_node(pos);

    }


    // Numbers of triangle sub-graphs in graph
    public Integer getSubGraphTriangles(int IndependentNodes, int Clique) {
        return (2 * IndependentNodes - Clique) / 3;
    }

    // Numbers of ticks and dots sub-graphs in graph/
    public Integer getSubGraphStickAndDots(double IndependentNodes, double Clique) {
        double k = (2 * Clique - IndependentNodes) / 3;
        if (k <= 1) {
            return 1;
        }
        return 0;
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

        int needed_size_list = IndependentNodes - 1;
//        List<String> list = new LinkedList<>();
        Map<Integer, ArrayList<String>> map = mapOfPairs;
        SituationD situationD = new SituationD();
        String pos = null;

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
                    copy_list.addAll(list);
                    System.out.println("Our copy -> " + copy_list);
                    i = map.get(0).size();
                    int g = 0;

                    for (int t = 0; t < list.size(); t = t + 2) {
                        System.out.println("C" + g + " -> " + list.get(t) + " " + list.get(t + 1));
                        g++;
                    }
                    System.out.println(list);
//                    copy_list.addAll(list);
//                    System.out.println("Our copy -> " + copy_list);
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


    public void get_graph_and_cut_fictitious_node() {
        System.out.println("This is how was it before -> " + C_to_N_Hash);
//        for (int i = 0; i < C_to_N_Hash.size(); i++) {
//            if (C_to_N_Hash.get(positionForCut))
//
//        }
        int i = 0;
        while (C_to_N_Hash.get(i) != C_to_N_Hash.get(C_to_N_Hash.size() - 1)) {
            i++;
        }

        C_to_N_Hash.remove(i);
        System.out.println("This is how our C to I connection changed -> " + C_to_N_Hash);


        for (int k = 0; k < copy_list.size() + 1; k++) {
            num_to_cut = k;
            String custed = Integer.toString(num_to_cut);
            if (!copy_list.contains(custed)) {
                copy_list.clear();
               break;
            }

        }

        for (int j = 0; j < C_to_N_Hash.size(); j++) {
            ArrayList<Integer> cur_array = C_to_N_Hash.get(j);
            for (int d = 0; d < cur_array.size(); d++) {
                if (cur_array.get(d) == num_to_cut) {
                    cur_array.remove(d);
                }
            }
        }
        System.out.println("This is our graph that we need ->" + C_to_N_Hash);
    }

    public String getNumForCut(String need_num) {
        return need_num;
    }

}





