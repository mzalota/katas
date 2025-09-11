package com.katas.blocks;

public class B04_SplitVariable {

    /*
     * We want to refactor and extract first if/else into two functions: calulcateIngredientsCosts() and cookingTimeHours()
     *
     * 1) Refactor: Introduce Variable. Place the cursor on the "line" variable assignment just below comment "process second line"
     * 2) In the top "if" block remove lines with the "cookingTimeHours" variables.
     * 3) In the second "if" block remove lines with the "ingredientsCost" variables.
     * 4) Intention: Move declaration of 'cookingTimeHours' closer to usages. Cursor on cookingTimeHours definition
     * 5) Refactor: Extract Method: first if block into "calulcateIngredientsCosts()" function.
     * 6) Refactor: Extract Method: second if block into "cookingTimeHours()" function.
     *
     */
    public void doingTwoThingsSmaller(boolean isHungry, int defaultValue) {
        // process first line
        String line = readLine();
        String[] headers = line.split(":");

        // process second line
        line = readLine();
        String[] values = line.split(":");

        // process last, thrid line
        String bottomComment = readLine();
    }

    private String readLine() {
        return "";
    }
}
