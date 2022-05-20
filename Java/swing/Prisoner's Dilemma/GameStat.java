/**********************************************************************************************
 * Name: Tejas M. Satam                                                                        *
 * JAVA ASSIGNMENT 03                                                                          *
 * TA: Sindhusha Parimi                                                                        *
 * Purpose: The purpose of the assignment is to develope a simple prisoner's dilemma game.     *
 *          The concepts used in this assignment are hash maps, arraylists, constructors,      *
 *          file handling.                                                                     *
 **********************************************************************************************/

package com.company;

public class GameStat {
    int userSentence;
    int compSentence;


    String winner;

    //getting the default constructor
    public GameStat(){
        this.userSentence = 0;
        this.compSentence = 0;
    }

    //This function will update the score
    public void update(int userSentence, int compSentence){
        this.userSentence = userSentence;
        this.compSentence = compSentence;
    }

    //This method will decided the will
    public String getWinner(){

        if(userSentence<compSentence)
        {
            winner = ("You are the winner");

            return(winner);
        }
        else if(userSentence==compSentence)
        {
            winner = ("It's a TIE");
            return(winner);
        }
        else
        {
            winner = ("Computer is winner");
            return(winner);
        }
    }//getWinner

    //getters and setters
    public int getUserSentence() {
        return userSentence;
    }

    public void setUserSentence(int userSentence) {
        this.userSentence = userSentence;
    }

    public int getCompSentence() {
        return compSentence;
    }

    public void setCompSentence(int compSentence) {
        this.compSentence = compSentence;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
