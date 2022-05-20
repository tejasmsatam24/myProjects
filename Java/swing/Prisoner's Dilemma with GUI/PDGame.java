/**********************************************************************************************
 * Name: Tejas M. Satam, Gopi Vinyas Musunuru                                                  *
 * JAVA ASSIGNMENT 04                                                                          *
 * ZID : Z1854197, Z1857015                                                                    *
 * TA: Sindhusha Parimi                                                                        *
 * Purpose: The purpose of the assignment is to understand various concepts of JAVA SWING      *
 **********************************************************************************************/




//package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class PDGame {

    //This array list will hold the user history, which we will use for one of the strategies
    ArrayList<Integer> user_choice_history = new ArrayList<>();

    //creating a list to hold the strategies
    ArrayList<String> computer_decision_list = new ArrayList<>();

    GameStat gs = new GameStat();
    private int strategy;
    private Scanner sc;

    int player_years_in_prison = 0;
    int computer_years_in_prison = 0;

    String condition;
    int count = 0;
    int dec;


    public PDGame(String file_name) {
        computer_decision_list.add("Read From File");
        computer_decision_list.add("Random Choice by Computer");
        computer_decision_list.add("Tit-For-Two-Tats");
        computer_decision_list.add("Tit-For-Tat");

        try
        {
            System.out.println("Hello :"+file_name);
            File file = new File(file_name);
            sc = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
            System.exit(0);
        }
    }//end PDGame

    //this function holds the logic for each round
    public String playRound(int decision) {
        dec = decision;
        int computer_Decision = ComputerDecision();
        user_choice_history.add(decision);
        if (decision == 1 && computer_Decision == 1) {
            condition = ("You and your partner wish to remain silent. \n" + "You both get 2 years in prison.");
            player_years_in_prison += 2;
            computer_years_in_prison += 2;  // both if them get 2yr
            gs.update(player_years_in_prison, computer_years_in_prison);
            return condition;

        } else if (decision == 2 && computer_Decision == 1) {

            condition = ("You wish to betray your partner and your partner wishes to remain silent \nYou get 1 year and your partner gets 5 years in prison.");
            player_years_in_prison += 1;  // if user testifies and computer remains silent
            computer_years_in_prison += 5;//user gets 1 yr and computer gets 5 yrs
            gs.update(player_years_in_prison, computer_years_in_prison);
            return condition;

        } else if (decision == 1 && computer_Decision == 2) {
            condition = ("You wish to remain silent and your partner wishes to betray you \nYou get 5 years and your partner gets 1 year in prison");
            player_years_in_prison += 5; // if user remains silent and computer testifies
            computer_years_in_prison += 1;// user gets 5 yrs and computer gets 1yr
            gs.update(player_years_in_prison, computer_years_in_prison);
            return condition;

        } else {
            condition = ("You and your partner wish to betray each other \nYou and your partner get 3 years in prison");
            player_years_in_prison += 3;
            computer_years_in_prison += 3;  // both get 3 yr sentencing
            gs.update(player_years_in_prison, computer_years_in_prison);
            return condition;
        }
    }//end playRound


    private int ComputerDecision() {

        //csse read from file
        if (strategy == 1) {
            return sc.nextInt();
        } else if (strategy == 2) {
            //case random decision
            return (int) (Math.random() * 2 + 1);
        } else if (strategy == 3) {
            //case Tic for Two Tats
            count++;
            if (count == 1 || count == 2) {
                return dec;
            } else {
                if (user_choice_history.get(0) == 2 && user_choice_history.get(1) == 2) {
                    return 2;
                } else
                    return dec;
            }
            //case Tic for tat
        } else if (user_choice_history.isEmpty()) { // in Tit for Tat, first return 1
            return 1;
        } else {  // then return the previous value of the user
            int prevDecision = user_choice_history.get(user_choice_history.size() - 1);
            return prevDecision;
        }
    }//end computerDecision


    //setting getters and setters
    public ArrayList<String> getStrategies() {
        return computer_decision_list;
    }//end getStrategies

    public String getScores() {
        return "\nYour prison sentence is : " + gs.getUserSentence() + "\n" + "Your partners prison sentence is : " + gs.getCompSentence() + "\n" + "The winner is : "+gs.getWinner();
    }//end getScores

    public GameStat getStats() {
        return gs;
    }//end getStats

    public void setStrategy(int strategy) {
        this.strategy = strategy;
        gs.setCompStrategy(computer_decision_list.get(strategy - 1));
    }//end setStrategy

} // end of class