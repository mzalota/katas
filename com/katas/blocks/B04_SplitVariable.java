package com.katas.blocks;

public class B04_SplitVariable {

    /*
     * We want to refactor and extract first if/else into two functions: calulcateIngredientsCosts() and cookingTimeHours()
     *
     * 1) Refactor: Introduce Variable. Place the cursor on the "line" variable assignment just below comment "process second line".
     *   1a) Name the variable "line" - exactly the same name.
     * 2) Refactor: Rename Variable: new name "secondLine". Place the cursor on the newly created "line" variable.
     * 3) Intention: remove redundant Initializer. Place cursor on the "line" variable that is underlined in red
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
