/**********************************************************************************************
 * Name: Tejas M. Satam                                                                        *
 * JAVA ASSIGNMENT 03                                                                          *
 * TA: Sindhusha Parimi                                                                        *
 * Purpose: The purpose of the assignment is to develope a simple prisoner's dilemma game.     *
 *          The concepts used in this assignment are hash maps, arraylists, constructors,      *
 *          file handling.                                                                    *
 **********************************************************************************************/


package com.company;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PDGame {

    //declaring an array list to hold the moves in our text file
    ArrayList<String> str_text_file = new ArrayList<String>();
    //This array list will hold the user history, which we will use for one of the strategies
    ArrayList<Integer> user_choice_history = new ArrayList<Integer>();

    //This list will store computer's decision which from it will choose random numbers
    List<Integer> computer_decision_list = new ArrayList<>();
    //declaring the random function
    private Random rand = new Random();

    //Declaring the variables
    private int strategy;
    int computer_Decision;
    int i = 0;
    int player_years_in_prison = 0;
    int computer_years_in_prison = 0;

    int count = 0;
    GameStat gs = null;

    String condition;

    public PDGame(String text_file) throws FileNotFoundException {

        gs = new GameStat();

        //scanning the file
        File text = new File(text_file);
        Scanner sc = new Scanner(text);
        while (sc.hasNextLine()) {
            //sc.nextLine();
            String input = sc.nextLine();
            //adding the inputs from the file to the arrayList
            str_text_file.add(input);
        }

        //We will get the list of strategies
        ArrayList<String> get_S = getStrategies();
        System.out.println("Select a strategy from above for the Computer to use in the 5 rounds :  \n");
        System.out.println(get_S.get(0)+"\n"+get_S.get(1)+"\n"+get_S.get(2)+"\n"+get_S.get(3)+"\n");
        System.out.println("Select a strategy from above for the Computer to use in the 5 rounds : ");
        Scanner sc1 = new Scanner(System.in);
        setStrategy(sc1.nextInt());

    }//end pdgame constructor

    //setting the strategy
    public void setStrategy(int strategy_choice) {
        this.strategy = strategy_choice;
    }

    //this function holds the logic for each round
    public String playRound(int decision) {
        count++;
        user_choice_history.add(decision);
        //read from file

        //case : Computer makes decision from the text file
        if (strategy == 1) {

            computer_Decision = Integer.parseInt(str_text_file.get(i));
            i++;
            if (decision == 1 && computer_Decision == 1) {
                condition = ("You and your partner wish to remain silent. \nYou and your partner get 2 years in prison.");
                player_years_in_prison += 2;
                computer_years_in_prison += 2;
                //System.out.println("u\");

                gs.update(player_years_in_prison,computer_years_in_prison);

                //System.out.println("You both get 2 years in prison");
            } else if (decision == 2 && computer_Decision == 1) {
                condition = ("You wish to betray your partner and your partner wishes to remain silent \nYou get 1 year and your partner gets 5 years in prison.");
                player_years_in_prison += 1;
                computer_years_in_prison += 5;
                gs.update(player_years_in_prison,computer_years_in_prison);

                //System.out.println("You get 1 year in prison and your partner gets 5 years in prison");
            } else if (decision == 1 && computer_Decision == 2) {
                condition = ("You wish to remain silent and your partner wishes to betray you \nYou get 5 years and your partner gets 1 year in prison");
                player_years_in_prison += 5;
               computer_years_in_prison += 1;
                gs.update(player_years_in_prison,computer_years_in_prison);

                //System.out.println("You get 5 years in prison and your partner gets 1 year in prison");
            } else if (decision == 2 && computer_Decision == 2) {
                condition = ("You and your partner wish to betray each other \nYou and your partner get 3 years in prison");
                player_years_in_prison += 3;
               computer_years_in_prison += 3;
                gs.update(player_years_in_prison,computer_years_in_prison);

                //System.out.println("You both get 3 years in prison");
            }

        }

        //case : Tic Tac Toe
        else if (strategy == 2) {
            i++;
            //System.out.println(i);
            if (i == 1) {
                computer_Decision = decision;
            } else {
                computer_Decision = user_choice_history.get(i - 2);
            }

            if (decision == 1 && computer_Decision == 1) {
                condition = ("You and your partner wish to remain silent. \nYou and your partner get 2 years in prison.");
                player_years_in_prison += 2;
                computer_years_in_prison += 2;
                gs.update(player_years_in_prison,computer_years_in_prison);
            } else if (decision == 2 && computer_Decision == 1) {
                condition = ("You wish to betray your partner and your partner wishes to remain silent \nYou get 1 year and your partner gets 5 years in prison.");
                player_years_in_prison += 1;
                computer_years_in_prison += 5;
                gs.update(player_years_in_prison,computer_years_in_prison);
            } else if (decision == 1 && computer_Decision == 2) {
                condition = ("You wish to remain silent and your partner wishes to betray you \nYou get 5 years and your partner gets 1 year in prison");
                player_years_in_prison += 5;
                computer_years_in_prison += 1;
                gs.update(player_years_in_prison,computer_years_in_prison);
            } else if (decision == 2 && computer_Decision == 2) {
                condition = ("You and your partner wish to betray each other \nYou and your partner get 3 years in prison");
                player_years_in_prison += 3;
                computer_years_in_prison += 3;
                gs.update(player_years_in_prison,computer_years_in_prison);
            }

        }

        //Tit for Two tats

        else if (strategy == 3) {
            i++;
            //System.out.println(i);
            if (i == 1 || i == 2) {
                computer_Decision = decision;
            } else {
                if (user_choice_history.get(0) == 2 && user_choice_history.get(1) == 2)
                    computer_Decision = 2;

                else
                    computer_Decision = decision;
                //computer_Decision = user_choice_history.get(i-2);
            }

            if (decision == 1 && computer_Decision == 1) {
                condition = ("You and your partner wish to remain silent. \nYou and your partner get 2 years in prison.");
                player_years_in_prison += 2;
                computer_years_in_prison += 2;
                gs.update(player_years_in_prison,computer_years_in_prison);
                //System.out.println("You both get 2 years in prison");
            } else if (decision == 2 && computer_Decision == 1) {
                condition = ("You wish to betray your partner and your partner wishes to remain silent \nYou get 1 year and your partner gets 5 years in prison.");
                player_years_in_prison += 1;
                computer_years_in_prison += 5;
                gs.update(player_years_in_prison,computer_years_in_prison);
                //System.out.println("You get 1 year in prison and your partner gets 5 years in prison");
            } else if (decision == 1 && computer_Decision == 2) {
                condition = ("You wish to remain silent and your partner wishes to betray you \nYou get 5 years and your partner gets 1 year in prison");
                player_years_in_prison += 5;
                computer_years_in_prison += 1;
                gs.update(player_years_in_prison,computer_years_in_prison);
                //System.out.println("You get 5 years in prison and your partner gets 1 year in prison");
            } else if (decision == 2 && computer_Decision == 2) {
                condition = ("You and your partner wish to betray each other \nYou and your partner get 3 years in prison");
                player_years_in_prison += 3;
                computer_years_in_prison += 3;
                gs.update(player_years_in_prison,computer_years_in_prison);
                //System.out.println("You both get 3 years in prison");
            }

        }


        //case: Random
        if(strategy == 4)
        {
            computer_decision_list.add(1);
            computer_decision_list.add(2);
           computer_Decision = this.getRandomElement(computer_decision_list);
            //System.out.println(computer_Decision);
            if (decision == 1 && computer_Decision == 1) {
                condition = ("You and your partner wish to remain silent. \nYou and your partner get 2 years in prison.");
                player_years_in_prison += 2;
                computer_years_in_prison += 2;
                gs.update(player_years_in_prison,computer_years_in_prison);
            } else if (decision == 2 && computer_Decision == 1) {
                condition = ("You wish to betray your partner and your partner wishes to remain silent \nYou get 1 year and your partner gets 5 years in prison.");
                player_years_in_prison += 1;
                computer_years_in_prison += 5;
                gs.update(player_years_in_prison,computer_years_in_prison);
            } else if (decision == 1 && computer_Decision == 2) {
                condition = ("You wish to remain silent and your partner wishes to betray you \nYou get 5 years and your partner gets 1 year in prison");
                player_years_in_prison += 5;
                computer_years_in_prison += 1;
                gs.update(player_years_in_prison,computer_years_in_prison);
            } else if (decision == 2 && computer_Decision == 2) {
                condition = ("You and your partner wish to betray each other \nYou and your partner get 3 years in prison");
                player_years_in_prison += 3;
                computer_years_in_prison += 3;
                gs.update(player_years_in_prison,computer_years_in_prison);
            }

        }
        //end of Random
        if(count == 5)
        {
            computer_years_in_prison = 0;
            player_years_in_prison = 0;
            count = 0;
        }
        return condition;
    }

    //getter to get game stats
    public GameStat getGs(){
        return this.gs;
    }

    //getter to get strategy
    public int getStrategy(){
        return this.strategy;
    }

    //clear the stats
    public void clear(){
        this.gs = new GameStat();
    }

    //List of strategies
    public ArrayList<String> getStrategies(){

        ArrayList<String> getStrategies = new ArrayList<>();
        getStrategies.add("1. Computer Reads Strategy From Input File");
        getStrategies.add("2. Tit-For-Tat");
        getStrategies.add("3. Tit-For-Two-Tats");
        getStrategies.add("4. Random Choice by Computer");

        return getStrategies;

    }

    //getting the scores to display after every round
    public String getScores(){
        //return gs.getWinner();
        //gs.getWinner();
       return("Your prison sentence is :"+gs.userSentence+"\nYour partner's/computer prison sentence is :"+gs.compSentence+"\n"+gs.getWinner());

    }


    //random function
    public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}

