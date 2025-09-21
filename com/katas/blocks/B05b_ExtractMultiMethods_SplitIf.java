package com.katas.blocks;

import java.util.List;


/*
 * Refactoring flow: "SplitIfs using multi-output Result record"
 *
 * 1) Refactor: "Extract Method". Select the first if/else statement and declarations above it in the doingTwoThingsSmaller() method.
 *   1a) Name new record: Result
 *   1b) Name of new variable: "resultMultiOut"
 *   1c) Name new method: getResult()
 *
 * -- boolean calculateCookingTimeHours()
 * 2) Refactor: "Introduce Variable": cookingTimeHours - select "resultMultiOut.cookingTimeHours()" in the the doingTwoThingsSmaller() method.
 *  2a) In the "Multiple occurrences found" dialog select "Replace all 3 occurrences".
 * 3) Refactor: "Inline Variable": resultMultiOut. Place the cursor on "resultMultiOut" in "resultMultiOut.cookingTimeHours()" snippet.
 *  3a) In the "Multiple occurrences found" dialog select "This reference only".
 * 4) Refactor: "Extract Method": calculateCookingTimeHours() - select "getResult(isHungry).cookingTimeHours()" snippet.
 * 5) Refactor: "Inline Method". Place the cursor on the getResult() call inside the calculateCookingTimeHours() method.
 *  5a) In the "Inline Method" dialog select the "Inline this usage only, keep the method" option.
 * 6) Refactor: "Inline Variable": result.
 * 7) Manually replace "new Result(ingredientsCost, cookingTimeHours).cookingTimeHours();" with "return cookingTimeHours;"
 * 8) Intention: "Move 'return' closer to computation of the value of 'cookingTimeHours'". Place the cursor on the "return cookingTimeHours;".
 * 9) Intention: "Remove redundant assignment". Place the cursor on the "ingredientsCost" variable in the else block.
 *   9a) In the "Remove Redundant Assignment" dialog select "Delete assignment completely". It's OK because calculateSmallNumber() does not have any side-effects.
 * 10) Intention: "Remove redundant assignment". Place the cursor on the "ingredientsCost" variable in the if block.
 *   10a) In the "Remove Redundant Assignment" dialog select "Delete assignment completely". It's OK because calculateLargeFactor() does not have any side-effects.
 * 11) Intention: "Remove local variable 'ingredientsCost'". Place the cursor on the definition of the "ingredientsCost" variable.
 *
 *  * -- boolean calculateIngredientsCost()
 * 12) Refactor: "Introduce Variable": ingredientsCost - select "resultMultiOut.ingredientsCost()" in the the doingTwoThingsSmaller() method.
 * 13) Refactor: "Inline Variable": resultMultiOut. Place the cursor on "resultMultiOut" in "resultMultiOut.ingredientsCost()" snippet.
 * 14) Refactor: "Extract Method": calculateIngredientsCost() - select "getResult(isHungry).ingredientsCost()" snippet.
 * 15) Refactor: "Inline Method". Place the cursor on the getResult() call inside the calculateIngredientsCost() method.
 *  15a) In the "Inline Method" dialog select the "Inline all usages and remove the method" option.
 * 16) Refactor: "Inline Variable": result.
 * 17) Manually replace "new Result(ingredientsCost, cookingTimeHours).ingredientsCost();" with "return ingredientsCost;"
 * 18) Intention: "Remove redundant assignment". Place the cursor on the "cookingTimeHours" variable in the else block.
 *   18a) In the "Remove Redundant Assignment" dialog select "Delete assignment completely". It's OK because calculateSmallNumber() does not have any side-effects.
 * 19) Intention: "Remove redundant assignment". Place the cursor on the "cookingTimeHours" variable in the if block.
 *   19a) In the "Remove Redundant Assignment" dialog select "Delete assignment completely". It's OK because calculateLargeFactor() does not have any side-effects.
 * 20) Intention: "Remove local variable 'cookingTimeHours'". Place the cursor on the definition of the "cookingTimeHours" variable.
 * 21) Intention: "Move 'return' closer to computation of the value of 'ingredientsCost'". Place the cursor on the "return ingredientsCost;".
 *
 * 22) Intention: Safe delete 'com.katas.blocks.B04_SplitIfs.Result. Place the cursor on the Result record definition.
 */


public class B05b_ExtractMultiMethods_SplitIf {

    public double doingTwoThingsSmaller(boolean isHungry, int defaultValue) {

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
            double minimumWagePerHour = 18.5;
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

    //--- old kata code...
    public int extractIndividualLogicOutOfForLoop(List<Integer> list) {
        int result = 1;
        boolean needToSaveToDB =false;
        if (list.size() > 10) {
            System.out.println("Match found at element number:");
            result = computeFactor(0, list.get(0));
            needToSaveToDB = true;
        } else {
            System.out.println("List is too small. Using default Factor");
            return 3;
        }

        if(needToSaveToDB) {
            System.out.println("Saving to DB: " + result);
        }
        return result;
    }

    private int computeFactor(int count, Integer element) {
        return element*count;
    }
}