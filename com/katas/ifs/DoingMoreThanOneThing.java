package com.katas.ifs;

public class DoingMoreThanOneThing {

    public double doingTwoThingsSmaller(boolean isHungry, int defaultValue) {
        double minimumWagePerHour = 18.5;

        //culculate the Number and the Factor
        int ingredientsCost = 0;
        double cookingTimeHours = 1;
        if (isHungry) {
            System.out.println("In if top: she is hungry");
            ingredientsCost = calculateLargeNumber("ACTION - eat the food AA");
            cookingTimeHours = calculateLargeFactor("ACTION - cook something tasty AA");
        } else {
            ingredientsCost = calculateSmallNumber("ACTION - eat the food CCC");
            cookingTimeHours = calculateSmallFactor("ACTION - cook something tasty CCC");
        }

        //Save to DB if necessary
        if (cookingTimeHours==0){
            saveToDB(String.valueOf(defaultValue));
            System.out.println("Saved default value to DB");
        } else {
            double mealCost = cookingTimeHours*minimumWagePerHour + ingredientsCost;
            System.out.println("Saving calculated mealCost to DB");
            saveToDB(String.valueOf(mealCost));
        }

        return cookingTimeHours;
    }
    protected double calculateLargeFactor(String message) {
        return 5.4;
    }

    protected double calculateSmallFactor(String message) {
        return 5.4;
    }

    protected int calculateSmallNumber(String message) {
        System.out.println(message);
        return 7;
    }
    protected int calculateLargeNumber(String message) {
        System.out.println(message);
        return 7;
    }
    protected void saveToDB(String valueToStore) {
        System.out.println("Committing to DB value: " + valueToStore);
    }
}
