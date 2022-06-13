package back;


import back.sectionA.SituationA;
import back.sectionC.SituationC;
import back.sectionD.SituationD;
import front.MyFrame;
import java.util.*;


public class MainClass {
    public static void main(String[] args) {
        new MyFrame();

        SituationA situationA = new SituationA();
        SituationC situationC = new SituationC();
        SituationD situationD = new SituationD();

        Scanner input = new Scanner(System.in);
        System.out.println("Please choice what split you wanna see:");
        int msg;

        do {
            System.out.println("[Situation A] -> 1");
            System.out.println("[Situation B] -> 2");
            System.out.println("[Situation C] -> 3");
            System.out.println("[Situation D] -> 4");
            System.out.println("[Situation E] -> 5");
            System.out.println("[EXIT]        -> 0");
            msg = input.nextInt();


            switch (msg) {
                case 1 -> {
                    situationA.CreateGraph(40, 10);
                    System.out.println("1");
                }
                case 2 -> System.out.println("2");
                case 3 -> {
                    System.out.println("3");
                    situationC.CreateGraph(8, 4);
                    situationC.search_All_two_matches();
                }
                case 4 -> {
                    situationD.CreateGraph(7,4);
                    situationD.search_All_two_matches();
                    situationD.get_graph_and_cut_fictitious_node();

                }

                case 5 -> System.out.println("5");
                case 0 -> System.out.println("End of process...");
            }

        } while (msg != 0);

    }


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

}