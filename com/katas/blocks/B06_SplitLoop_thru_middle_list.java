package com.katas.blocks;

import java.util.List;


/*
 * Refactoring flow: "Separate logic inside for loop into two separate methods"
 *
 * 1) Refactor: Extract method: place the cursor on the System.out.println inside for loop.
 *  1a) Name method logicToMove().
 *  1b) Click Keep original signature button.
 *  1c) Notice that this method takes only one parameter - string
 * 2) Manually add "result.add(string);" above "logicToMove(string);" line
 * 3) Intention: create local variable 'result'. Place the cursor on the "result" variable.
 *  3a) Write List as variable type.
 * 4) Intention: Initialize variable 'result'. Place the cursor on the "result" variable. Select "List.of()" option.
 * 5) Intention: Replace with 'new ArrayList<>()'. Place the cursor on the "List.of()" term.
 * 6) Code Completion Basic: Select String. Place cursor inside angle brackers<> in "new ArrayList<>();" snippet.
 * 7) Intention: Change type of result to List<String>. Place the cursor on List in "List<String> result = new ArrayList<>();" snippet
 * 8) Manually write "result" below the end of the outer for loop.
 * 9) Intention: Bring 'List<String> result' into scope. Place the cursor on the just written "result" word.
 * 10) Manually move "result = new ArrayList<>();" line up to just below "List<String> result = null;"
 * 11) Intention: Remove redundant initializer. Place the cursor on the "null" word.
 * 12) Intention: Join declaration and assignment. Place the cursor on the result variable declaration.
 * 13) Intention: Iterate over List<String>. Place the cursor on the result word below for loop.
 *  13a) Give the variable in the new for loop the name "string" to be the same as in "result.add(string);" statement.
 * 14) Manually cut the call to the logicToMove(string) method and paste it into the newly created for loop.
 * 15) Refactor: Inline Method logicToMove(). Select the "Inline all usages, remove the mothod" option.
 *
 */

public class B06_SplitLoop_thru_middle_list {

    public void separateTwoAspectsInOneLoop(List<Integer> list, List<String> strings) {
        for (Integer element : list) {
            if (element % 2 == 0) {
                for (String string : strings) {
                    if (string.equals(Integer.toString(element))) {
                        System.out.println("Even number. Exists in both lists: "+string);
                    }
                }
            } else {
                System.out.println("Odd number. Skip it");
            }

        }
    }

}
