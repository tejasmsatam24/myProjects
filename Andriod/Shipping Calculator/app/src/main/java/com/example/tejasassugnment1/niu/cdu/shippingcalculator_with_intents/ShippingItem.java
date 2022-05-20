package com.example.tejasassugnment1.niu.cdu.shippingcalculator_with_intents;

public class ShippingItem {

        //declaring the constants
        static final Double BASE_AMOUNT = 3.00, ADDED_COST = 0.50, EXTRA_OUNCES = 4.0;
        static final int BASE_WEIGHT = 16;

        //declaring the variables
        private Integer weight;
        private double baseCost, addedCost, totalCost;


        //This function will hold the initial values
        public ShippingItem() {
            weight = 0;
            baseCost = BASE_AMOUNT;
            addedCost = 0.0;
            totalCost = 0.0;
        }

        public void setWeight(Integer newWeight) {
            weight = newWeight;
            computeCost();

        }
        public void computeCost()
        {
            baseCost = BASE_AMOUNT;
            if(weight <= 0)
            {
                baseCost = 0.0;
            }
            addedCost = 0.0;

            //here if the weight is grater than the base weight than we will comoute the added cost
            if(weight>BASE_WEIGHT)
                addedCost = Math.ceil((weight - BASE_WEIGHT)/EXTRA_OUNCES)*ADDED_COST;
            //calculate the total cost
            totalCost = baseCost + addedCost;

        }//end computeCost

        public double getBaseCost() {
            return baseCost;
        }

        public double getAddedCost() {
            return addedCost;
        }

        public double getTotalCost() {
            return totalCost;
        }
}
