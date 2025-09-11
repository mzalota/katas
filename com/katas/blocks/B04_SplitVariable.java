package com.katas.blocks;

public class B04_SplitVariable {

    /*
     * Dont reuse line variable. Create separate variable ("split variable") under comment "process second line".
     *
     * 1) Refactor: Introduce Variable. Place the cursor on the "line" variable assignment just below comment "process second line".
     *   1a) Name the variable "line" - exactly the same name.
     * 2) Refactor: Rename Variable: new name "secondLine". Place the cursor on the newly created "line" variable.
     * 3) Intention: Remove redundant initializer. Place cursor on the "secondLine" variable that is underlined in red.
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
