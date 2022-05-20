package com.example.tejasassugnment1.niu.cdu.tejas_satam_calorie_calculator;

public class Burger {
    static final int BEEF=90,
            TURKEY=170,
            VEGGIE=150,
            CHEDDAR=113,
            MOZZ=78,
            BACON=86;
    //Instance Variables
    private int pattyCalories, cheeseCalories,baconCalories,sauceCalories;
    //Constructor

    public Burger()
    {
        pattyCalories = BEEF;
        cheeseCalories = 0;

    }//end constructor

    //Setters
    public void setPattyCalories(int newPattyCalories) {
        this.pattyCalories = newPattyCalories;
    }

    public void setCheeseCalories(int newCheeseCalories) {
        this.cheeseCalories = newCheeseCalories;
    }

    public void setBaconCalories(boolean hasBacon) {
        baconCalories = 0;
        if(hasBacon) {
            baconCalories = BACON;
        }
    }

    public void setSauceCalories(int newSauceCalories) {
        this.sauceCalories = newSauceCalories;
    }
    //Getter
    public int getTotalCalories() {
        return pattyCalories+baconCalories+cheeseCalories+sauceCalories;
    }


}//End of Burger class


