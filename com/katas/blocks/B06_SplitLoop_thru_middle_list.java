package com.katas.blocks;

import java.util.List;


/*
 * Refactoring flow: "Separate logic inside for loop into two separate methods"
 *
1) Refactor: Extract method: place the cursor on the System.out.println inside for loop.
  1a) Name method logicToMove(). Notice that this method takes only one parameter - string
* 1) Manually add "result.add(string);" above "System.out.println("Even number. Exists in both lists: "+string);" line
2) Intention: create local variable result. Place the cursor on the "result" variable.
  2a) Write List<E> as variable type
3) Intention: Initialize variable 'result'. Place the cursor on the "result" variable. Select "List.of()" option.
4) Intention: Replace with 'new ArrayList<>()'. Place the cursor on the "List.of()" term.
5) Intention: Change type of 'result' to List<Object>. Place the cursor on the "List" type declaration of the "List result =" variable.
6) Manually replace change typ of list from "List<Object>" to List<String>
7) Manually write "result" below the end of the for loop.
8) Intention: Bring 'List<String> result' into scope. Place the cursor on the just written "result" word.
9) Manually move "result = new ArrayList<>();" line up to just below "List<String> result = null;"
10) Intention: Remove redundant initializer. Place the cursor on "null" term.
11) Intention: Join declaration and assignment. Place the cursor on result variable declaration.
12) Intention: Iterate over List<String>. Place the cursor on the result word below for loop.
  12a) Give the variable in the new for loop the name "string" to be the same as in "result.add(string);" statement.
13) Manually cut the call to the logicToMove(string) method and paste it into the newly created for loop.
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
            }
            System.out.println("Odd number. Skip it");
        }
    }

}
