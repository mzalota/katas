package com.katas.functions;

import java.util.ArrayList;
import java.util.List;


/*
 * Refactoring flow: "Separate logic inside for loop into two separate methods"
 *
 * 1) Refactor: "Extract Method": getResult(list) - for loop and definition of numbers and strings arrays. Result record will be created.
 * 2) Refactor: "Introduce Variable": numbers - select "result.numbers()" in separateTwoAspectsInOneLoop() method.
 * 3) Refactor: "Introduce Variable": strings - select "result.strings()" in separateTwoAspectsInOneLoop() method.
 *
 * --- getNumbers()
 * 4) Refactor: "Inline Variable": result - select "result" in "result.numbers()". Select "This reference only".
 * 5) Refactor: "Extract Method": getNumbers(list) - select "getResult(list).numbers()" snippet.
 * 6) Refactor: "Inline Method": getResult() inside getNumbers() method. Select "Inline this usage only, keep the method" option
 * 7) Refactor: "Inline Variable": numbers.
 * 8) Refactor: "Inline Variable": result.
 * 9) Manually replace "return new Result(numbers1, strings).numbers();" with "return numbers1;"
 * 10) Remove code in else statement in getNumbers() method. We don't need strings list in this method.
 * 11) Intention: "Remove local variable 'strings'". Cursor on the definition of strings variable in getNumbers() method.
 * 12) Refactor: "Rename...". Cursor on numbers1 in getNumbers() method.
 *
 * -- getStrings()
 * --repeat steps 4-12, but for strings list.
 */
public class SeparateLogicFromSingleForLoop {

    public void separateTwoAspectsInOneLoop(List<Integer> list) {

        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (Integer element : list) {
            if (element % 2 == 0) {
                System.out.println("Even number. Add to numbers list");
                numbers.add(element);
            } else {
                System.out.println("Odd number. Add to strings list");
                strings.add(String.valueOf(element));
            }
        }
        doSomeLogic(numbers, strings);
    }

    private void doSomeLogic(ArrayList<Number> numbers, ArrayList<String> strings) {
        System.out.println(numbers.size());
        System.out.println(strings.size());
    }
}
