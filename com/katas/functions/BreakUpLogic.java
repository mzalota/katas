package com.katas.functions;

import java.util.ArrayList;
import java.util.List;


/*
* Refactoring flow: "Push logic down-stack" and "Pull logic up-stack"
*
* ---Push logic "down-stack" (to the function "below")
* 1) Refactor: "Extract Method": lookupPriceInDBNew() - select last two lines in the method getBaselinePrice().
* 2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
* 3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
*
* --- Pull logic "up-stack" (to the function "above")
* 1) Refactor: "Extract Method": lookupPriceInDBNew() - content last line in the method lookupPriceInDB().
* 2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
* 3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
*
*/
public class BreakUpLogic {

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
