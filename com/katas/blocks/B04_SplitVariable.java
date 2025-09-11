package com.katas.blocks;

public class B04_SplitVariable {

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
    public void doingTwoThingsSmaller(boolean isHungry, int defaultValue) {
        String line = readLine();
        String[] headers = line.split(":");

        line = readLine();
        String[] values = line.split(":");

        String bottomComment = readLine();
    }

    private String readLine() {
        return "";
    }
}
