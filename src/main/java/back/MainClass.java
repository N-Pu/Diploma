package back;


import java.io.*;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please choice what split you wanna see:");
        int msg;

        do {
            System.out.println("[Situation 1] -> 1");
            System.out.println("[Situation 2] -> 2");
            System.out.println("[Situation 3] -> 3");
            System.out.println("[Situation 4] -> 4");
            System.out.println("[Situation 5] -> 5");
            System.out.println("[EXIT]        -> 0");
            msg = input.nextInt();


            switch (msg) {

                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 0:
                default:
                    System.out.println("[Wrong Number]");
            }

        } while (msg != 0);

    }

}