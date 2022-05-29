package back;


import java.io.*;


public class MainClass {
    public static void main(String[] args) throws IOException {


//        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph graph = new Graph();

        boolean is_exit = false;

        while (!is_exit) {
            System.out.println("""
                    [Situation A]       : 1
                    [Situation B]       : 2\s
                    [Situation C]       : 3\s
                    [Situation D]       : 4\s
                    [Situation E]       : 5\s
                    [Exit]              : 0\s
                    """);

            int token = Integer.parseInt(br.readLine());
            switch (token) {
                case 1:
                    System.out.println("f");
                    continue;
                case 2:
                    continue;
                case 3:
                    continue;
                case 4:
                    continue;
                case 5:
                    continue;
                case 0:
                    is_exit = true;
                    break;
            }


        }


//        Graph graph = new Graph();
        int getCliqueNum = graph.Randomizer(5, 30);
        int getIndependentNodesNum = graph.Randomizer(5, 30);


        graph.CreateGraph(getIndependentNodesNum, getCliqueNum);
        System.out.println("[Nodes in Clique] --> " + getCliqueNum);
        System.out.println("[Nodes in IndependentNodes] --> " + getIndependentNodesNum);

    }
}
