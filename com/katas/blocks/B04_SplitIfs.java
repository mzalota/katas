package com.katas.blocks;

public class B04_SplitIfs {


    /*
     * We want to refactor and extract first if/else into two functions: calulcateIngredientsCosts() and cookingTimeHours()
     *
     * 1) Duplicate first if/else block.
     * 2) In the top "if" block remove lines with the "cookingTimeHours" variables.
     * 3) In the second "if" block remove lines with the "ingredientsCost" variables.
     * 4) Intention: Move declaration of 'cookingTimeHours' closer to usages. Cursor on cookingTimeHours definition
     * 5) Refactor: Extract Method: first if block into "calulcateIngredientsCosts()" function.
     * 6) Refactor: Extract Method: second if block into "cookingTimeHours()" function.
     *
     */
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
