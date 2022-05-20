/**********************************************************************************************
 * Name: Tejas M. Satam, Gopi Vinyas Musunuru * JAVA ASSIGNMENT 04 * ZID :
 * Z1854197, Z1857015 * TA: Sindhusha Parimi * Purpose: The purpose of the
 * assignment is to understand various concepts of JAVA SWING *
 **********************************************************************************************/

// package com.company;

public class GameStat {
    String compStrategy;
    int userSentence;
    int compSentence;
    int rounds;
    String winner;

    // getting the default constructor
    public GameStat() {
        this.userSentence = 0;
        this.compSentence = 0;
        this.rounds = 0;
    }

    // This function will update the score
    public void update(int userSentence, int compSentence) {
        this.userSentence = userSentence;
        this.compSentence = compSentence;
        rounds++;
    }

    // This method will decided the winner
    public String getWinner() {
        if (userSentence < compSentence) {
            winner = "Player";
            return winner;
        } else if (compSentence == userSentence) {
            winner = "Its a TIE";
            return winner;
        } else {
            winner = "Computer";
            return winner;
        }

    }// getWinner

    // getters and setters
    public int getUserSentence() {
        return userSentence;
    }

    public int getCompSentence() {
        return compSentence;
    }
    // setters are used to set the private variables of the class

    public void setCompStrategy(String compStrategy) {
        this.compStrategy = compStrategy;
    }

    public String getCompStrategy() {
        return compStrategy;
    }

    public int getRounds() {
        return rounds;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}