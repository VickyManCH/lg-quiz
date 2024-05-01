package main;

import item.base.BaseQuiz;
import item.usage.ChoiceType;
import player.NegativePosException;
import player.QuizGame;
import item.base.BaseQuestion;
import java.util.ArrayList;
import java.util.Scanner;
import player.QuizGame;

public class Main {


    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println(" Welcome To Lg_Game");
        Scanner sc = new Scanner(System.in);
        //!gs.isGameEnd()
        while (true) {
            System.out.println("======================================================================");
            int amount = gs.getMonkeyContainer().size();
            if (amount == 3) {
                System.out.println("If you want to reselect the monkeys please press <0>.");
            } else {
                System.out.println("Please select 3 monkeys before start the game.");
            }
            System.out.println("<0> Select Monkeys for your team");
            System.out.println("<1> START GAME");
            System.out.println("======================================================================");
            int choice = inputCheck(0, 1);
            if (choice == 0) {
                gs.getMonkeyContainer().clear();
                for (int i = 0; i < 3; i++) {
                    ArrayList<String> lst = new ArrayList<>();
                    lst.add("first");
                    lst.add("second");
                    lst.add("third");
                    System.out.println("======================================================================");
                    System.out.println("please select your " + lst.get(i) + " monkey.");
                    selectMonkeyFlow();
                }
                System.out.println("======================================================================");
                System.out.print("Our Army:\n");
                for (BaseMonkey m : gs.getMonkeyContainer()) {
                    System.out.println(m.toString());
                }
            } else if (choice == 1) {
                System.out.println("<1> START GAME");
                startGameFlow();
                if (gs.isGameEnd()) break;
            }
        }
        System.out.println("---------- Game is Over -----------");
    }






}
