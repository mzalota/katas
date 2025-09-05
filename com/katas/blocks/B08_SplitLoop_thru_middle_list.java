package com.katas.blocks;

import java.util.List;


/*
 * Refactoring flow: "Separate logic inside for loop into two separate methods"
 *
 * 1) Refactor: "Extract Method": getResult(list) - for loop and definition of numbers and strings arrays. Result record will be created.
 * 2) Refactor: "Introduce Variable": numbers - select "result.numbers()" in separateTwoAspectsInOneLoop() method.
 * 3) Refactor: "Introduce Variable": strings - select "result.strings()" in separateTwoAspectsInOneLoop() method.
 * 4) Refactor: "Inline Variable": result - select "result" in "result.numbers()". Select "This reference only".
 * 5) Refactor: "Inline Variable": result - select "result" in "result.strings()". Result variable disappears.
 *
 * --- getNumbers()
 * 6) Refactor: "Extract Method": getNumbers(list) - select "getResult(list).numbers()" snippet.
 * 7) Refactor: "Inline Method": getResult() inside getNumbers() method. Select "Inline this usage only, keep the method" option
 * 8) Refactor: "Inline Variable": result. Inside getNumbers() method.
 * 9) Manually replace "return new Result(numbers, strings).numbers();" with "return numbers;"
 * 10) Remove code in else statement in getNumbers() method. We don't need strings list in this method.
 * 11) Intention: "Remove local variable 'strings'". Cursor on the definition of strings variable in getNumbers() method.
 *
 * -- getStrings()
 * repeat steps 6-11, but for ArrayList<String> strings variable in method separateTwoAspectsInOneLoop().
 *
 */

public class B08_SplitLoop_thru_middle_list {

    public void separateTwoAspectsInOneLoop(List<Integer> list, List<String> strings) {
        for (Integer element : list) {
            if (element % 2 == 0) {
                for (String string : strings) {
                    if (string.equals(Integer.toString(element))) {
                        System.out.println("Even number. Exists in both lists");
                    }
                }
            }
            System.out.println("Odd number. Skip it");
        }
    }

}
