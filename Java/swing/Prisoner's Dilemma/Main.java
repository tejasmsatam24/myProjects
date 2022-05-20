package com.company;
/**********************************************************************************************
* Name: Tejas M. Satam                                                                        *
* JAVA ASSIGNMENT 03                                                                          *
* TA: Sindhusha Parimi                                                                        *
* Purpose: The purpose of the assignment is to develope a simple prisoner's dilemma game.     *
*          The concepts used in this assignment are hash maps, arraylists, constructors,      *
 *          file handling.                                                                    *
**********************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //initializing the variables
        int player_decision;
        int round = 0;
        boolean playGame = true;
        char again;
        String Current_time_string;

        //Start the game
        System.out.println("***Starting A Game of Prisoner's Dilemma ***-5 rounds in this version of game \n\n");
        //setting the file path
        String text_file = "/Users/tejassatam/Desktop/Java Assignment 03/src/com/company/text.txt";

        //declaring the scanner
        Scanner sc3 = new Scanner(System.in);

        //declaring a map to store out game summary
        Map<String,GameStat> game_score  = new HashMap<>();

        //here we are setting a flag, so when user enter N the flag will be false and the game ends
        while(playGame==true)
        {
            PDGame pdGame = new PDGame(text_file);
            round = 0;

            //getting the date at the start of every game to keep it as a value for our summary
            Date Current_time = new Date();

            //a game will continue for 5 rounds
            do {
                round++;
                if(round==5)
                {
                    System.out.println("\nEND A ROUND - Here are your 2 choices");
                    System.out.println("1: Remain Silent");
                    System.out.println("2: Betray and testify against \n");
                    System.out.println(" ----What is your decision this round? ");
                }
                else {
                    System.out.println("\nBEGIN A ROUND - Here are your 2 choices");
                    System.out.println("1: Remain Silent");
                    System.out.println("2: Betray and testify against \n");
                    System.out.println(" ----What is your decision this round?");
                }
                Scanner sc2 = new Scanner(System.in);
                player_decision = sc2.nextInt();
                System.out.println(pdGame.playRound(player_decision));

            }while (round!=5);

            //This will display the scores after every game
            System.out.println(pdGame.getScores());

            //getting current time and converting it to string
            Current_time_string = Current_time.toString();

            //putting the current status and time into the hash map
            game_score.put(Current_time_string, pdGame.getGs());

            pdGame.clear();

            //do you want to play again
                System.out.println("Do you want to play again?:");
                again = sc3.next().charAt(0);
            if(again == 'N'|| again== 'n') {
            playGame = false;
            }
        }

        //So to sort the map i used Tree map, as tree map will sort our map by default as store values in it.
        Map<String, GameStat> sortedMap = new TreeMap<>(game_score);

        //printing the summary of the game
        System.out.println("\nSummary of games and session times:\n");
        for(String s : sortedMap.keySet()){
            System.out.println("Key: " + s + " The value is: " + game_score.get(s).getWinner());
        }
    }
}

